package CorhuilaApp.CorhuilaApp.Services;

import CorhuilaApp.CorhuilaApp.Entity.AcademicWork;
import CorhuilaApp.CorhuilaApp.Entity.Producto;
import CorhuilaApp.CorhuilaApp.Repository.AcademicWorkRepository;
import CorhuilaApp.CorhuilaApp.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final AcademicWorkRepository academicWorkRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository,
            AcademicWorkRepository academicWorkRepository) {
        this.productoRepository = productoRepository;
        this.academicWorkRepository = academicWorkRepository;
    }

    // Método para registrar un producto usando sus atributos individuales
    public Producto registrarProducto(String nombre, String descripcion, Long academicWorkId) {
        AcademicWork academicWork = academicWorkRepository.findById(academicWorkId)
                .orElseThrow(() -> new RuntimeException("AcademicWork no encontrada"));

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setAcademicWork(academicWork);

        return productoRepository.save(producto);
    }

    // Método para registrar un producto usando directamente el objeto Producto
    public Producto registrarProducto(Producto producto) {
        AcademicWork academicWork = academicWorkRepository.findById(producto.getAcademicWork().getId())
                .orElseThrow(() -> new RuntimeException("AcademicWork no encontrada"));
        producto.setAcademicWork(academicWork);
        return productoRepository.save(producto);
    }

    // Método para listar productos por AcademicWork ID
    public List<Producto> listarProductosPorAcademicWork(Long academicWorkId) {
        AcademicWork academicWork = academicWorkRepository.findById(academicWorkId)
                .orElseThrow(() -> new RuntimeException("AcademicWork no encontrada"));
        return productoRepository.findByAcademicWork(academicWork);
    }

    // Método para obtener un producto por su ID
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }
}
