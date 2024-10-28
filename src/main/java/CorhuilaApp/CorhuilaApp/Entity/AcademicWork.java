package CorhuilaApp.CorhuilaApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "Academic_Work")
public class AcademicWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_name", nullable = false)
    @NotBlank(message = "The name of the work name is required.")
    private String name;
    @Column(name = "estimated_weekly_time", nullable = false)
    @Min(value = 0, message = "Debe ser un número positivo")
    private Integer estimatedWeeklyTime;

    @Column(name = "estimated_semiannual_time", nullable = false)
    @Min(value = 0, message = "Debe ser un número positivo")
    private Integer estimatedSemiannualTime;
    @OneToMany(mappedBy = "academicWork", cascade = CascadeType.ALL)
    private List<Producto> productos;
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = true)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;

    @Column(name = "campus", nullable = true)
    private String campus;

}
