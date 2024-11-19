package CorhuilaApp.auxClass;

import java.util.List;
import java.util.stream.Collectors;

public class AcademicWorkDTO {
    private Long id;
    private String name;
    private int estimatedWeeklyTime;
    private int estimatedSemiannualTime;
    private List<ProductoDTO> productos;

    // Otros getters y setters...

    // Método para obtener los nombres y descripciones de productos como un solo string
    public String getProductosString() {
        if (productos == null || productos.isEmpty()) {
            return "No hay productos";
        }
        return productos.stream()
                .map(p -> p.getNombre() + ": " + p.getDescripcion())
                .collect(Collectors.joining(", "));
    }

    // Getters y setters restantes...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getEstimatedWeeklyTime() { return estimatedWeeklyTime; }
    public void setEstimatedWeeklyTime(int estimatedWeeklyTime) { this.estimatedWeeklyTime = estimatedWeeklyTime; }
    public int getEstimatedSemiannualTime() { return estimatedSemiannualTime; }
    public void setEstimatedSemiannualTime(int estimatedSemiannualTime) { this.estimatedSemiannualTime = estimatedSemiannualTime; }
    public List<ProductoDTO> getProductos() { return productos; }
    public void setProductos(List<ProductoDTO> productos) { this.productos = productos; }
}
