package co.edu.unisabana.sigaTutoriass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TutorDTO {


    private int id;


    @NotEmpty(message = "El nombre es requerido")
    @NotNull(message = "Mande el campo!")
    @Size(min = 3)
    private String nombre;

    @NotNull(message = "Mande el campo!")
    @Min(1)
    @Max(12)
    private int semestre;
    @NotNull(message = "Mande el campo!")
    private FacultadEnum facultad;
    @NotNull(message = "Mande el campo!")
    private ProgramaEnum programa;
    @NotNull(message = "Mande el campo!")
    private AsignaturaEnum asignatura;
    @NotEmpty(message = "Las habilidades son requeridas")
    @NotNull(message = "Mande el campo!")
    @Size(min = 5)
    private String habilidades;
    private String imagen;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorDTO that = (TutorDTO) o;
        return id == that.id && Objects.equals(imagen, that.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imagen);
    }


}
