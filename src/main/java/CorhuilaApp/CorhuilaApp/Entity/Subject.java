package CorhuilaApp.CorhuilaApp.Entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "Subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The subject name is required.")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = true)
    private String code;

    // Relación con el programa académico
    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private AcademicProgram academicProgram;

}
