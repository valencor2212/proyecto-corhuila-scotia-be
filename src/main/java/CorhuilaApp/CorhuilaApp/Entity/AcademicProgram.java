package CorhuilaApp.CorhuilaApp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Academic_Program")
public class AcademicProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name of the academic program is required.")
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "academicProgram", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subject> subjects; // Lista de asignaturas asociadas al programa académico

}
