package co.edu.unisabana.sigaTutoriass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TutoriaDTO {

    private int idTutoria;
    private String nombreTutor;
    private AsignaturaEnum asignaturaTutor;
    @NotNull(message = "La fecha es requerida")
    @Future(message = "La fecha debe ser una fecha futura")
    private LocalDate fecha;





}

