package CorhuilaApp.CorhuilaApp.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_number", nullable = false)
    private Integer groupNumber; // Número o identificador del grupo

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject; // Relación con la asignatura

    @Column(name = "capacity", nullable = true)
    private Integer capacity; // Capacidad de estudiantes en el grupo (opcional)

    @Column(name = "semester", nullable = true)
    private Integer semester; // Semestre al que pertenece el grupo (opcional)
}
