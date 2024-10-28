package CorhuilaApp.CorhuilaApp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Academic_Period")
public class AcademicPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private int year; // Año del periodo

    @Column(name = "semester", nullable = false)
    private int semester; // 1 para A, 2 para B

    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;

    @NotBlank(message = "The name of the academic period is required.")
    @Column(name = "name", nullable = false)
    private String name;
}
