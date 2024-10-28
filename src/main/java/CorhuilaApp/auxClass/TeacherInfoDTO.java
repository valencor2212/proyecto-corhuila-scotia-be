package CorhuilaApp.auxClass;

import java.time.LocalDate;

public class TeacherInfoDTO {
    private Long id;
    private String username;
    private String nombre;
    private String facultyName;
    private String academicProgram;
    private String academicPeriod;
    private LocalDate joinDate;

    // Constructor
    public TeacherInfoDTO(Long id, String username, String nombre, String facultyName,
            String academicProgram, String academicPeriod, LocalDate joinDate) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.facultyName = facultyName;
        this.academicProgram = academicProgram;
        this.academicPeriod = academicPeriod;
        this.joinDate = joinDate;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getAcademicProgram() {
        return academicProgram;
    }

    public void setAcademicProgram(String academicProgram) {
        this.academicProgram = academicProgram;
    }

    public String getAcademicPeriod() {
        return academicPeriod;
    }

    public void setAcademicPeriod(String academicPeriod) {
        this.academicPeriod = academicPeriod;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
