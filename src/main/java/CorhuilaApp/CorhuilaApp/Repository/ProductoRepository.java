package CorhuilaApp.CorhuilaApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import CorhuilaApp.CorhuilaApp.Entity.AcademicWork;
import CorhuilaApp.CorhuilaApp.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByAcademicWork(AcademicWork academicWork);
}
