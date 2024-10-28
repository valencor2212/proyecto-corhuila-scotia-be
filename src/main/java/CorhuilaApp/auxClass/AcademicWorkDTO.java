package CorhuilaApp.auxClass;

import java.util.List;

public class AcademicWorkDTO {
    private Long id;
    private String name;
    private int estimatedWeeklyTime;
    private int estimatedSemiannualTime;
    private List<ProductoDTO> productos;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstimatedWeeklyTime() {
        return estimatedWeeklyTime;
    }

    public void setEstimatedWeeklyTime(int estimatedWeeklyTime) {
        this.estimatedWeeklyTime = estimatedWeeklyTime;
    }

    public int getEstimatedSemiannualTime() {
        return estimatedSemiannualTime;
    }

    public void setEstimatedSemiannualTime(int estimatedSemiannualTime) {
        this.estimatedSemiannualTime = estimatedSemiannualTime;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }
}
