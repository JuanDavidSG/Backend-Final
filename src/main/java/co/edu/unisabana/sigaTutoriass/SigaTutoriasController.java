package co.edu.unisabana.sigaTutoriass;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/tutores")
public class SigaTutoriasController {

    private List<TutorDTO> tutorDTOList;
    private List<TutoriaDTO> tutoriaDTOList;

    public SigaTutoriasController() {
        this.tutorDTOList = new ArrayList<>();
        this.tutoriaDTOList = new ArrayList<>();
    }

    @GetMapping(path = "/")
    public List<TutorDTO> obtenerTutoresPorAsignatura(@RequestParam AsignaturaEnum asignatura) {
        List<TutorDTO> busqueda = new ArrayList<>();
        for (TutorDTO tutor : tutorDTOList) {
            if (tutor.getAsignatura() == asignatura) {
                busqueda.add(tutor);
            }
        }
        return busqueda;
    }

    @GetMapping(path = "/{id}")
    public TutorDTO obtenerTutorPorId(@PathVariable int id) {
        for (TutorDTO tutor : tutorDTOList) {
            if (tutor.getId() == id) {
                return tutor;
            }
        }
        return null;
    }

    @GetMapping(path = "/tutorias")
    public List<TutoriaDTO> obtenerTutorias() {
        return tutoriaDTOList;
    }

    @PostMapping(path = "/agendar-tutoria/{id}")
    public Respuesta agendarTutoria(@PathVariable int id, @RequestBody @Valid TutoriaDTO tutoriaDTO) {
        TutorDTO tutor = obtenerTutorPorId(id);
        if (tutor != null) {
            tutoriaDTO.setIdTutoria((int) (Math.random() * 1000));
            tutoriaDTO.setNombreTutor(tutor.getNombre());
            tutoriaDTO.setAsignaturaTutor(tutor.getAsignatura());
            tutoriaDTOList.add(tutoriaDTO);
            return new Respuesta("Tutoría agendada correctamente");
        } else {
            return new Respuesta("No se encontró el tutor con el ID especificado");
        }
    }

    @GetMapping(path = "/todos")
    public List<TutorDTO> obtenerTutores() {
        return tutorDTOList;
    }

    @PostMapping(path = "/crear")
    public Respuesta crearTutor(@RequestBody @Valid TutorDTO tutorDTO) {
        tutorDTO.setId((int) (Math.random() * 1000));
        tutorDTOList.add(tutorDTO);
        return new Respuesta("Tutor ingresado correctamente");
    }
}

