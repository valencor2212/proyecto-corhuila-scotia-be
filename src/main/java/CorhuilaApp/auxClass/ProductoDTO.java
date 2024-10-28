package CorhuilaApp.auxClass;

public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private Long academicWorkId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getAcademicWorkId() {
        return academicWorkId;
    }

    public void setAcademicWorkId(Long academicWorkId) {
        this.academicWorkId = academicWorkId;
    }
}
