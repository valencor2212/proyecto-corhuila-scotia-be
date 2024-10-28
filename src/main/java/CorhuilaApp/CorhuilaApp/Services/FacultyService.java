package CorhuilaApp.CorhuilaApp.Services;

import CorhuilaApp.CorhuilaApp.Entity.Faculty;
import CorhuilaApp.CorhuilaApp.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    // Obtener todas las facultades
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    // Buscar facultad por ID
    public Optional<Faculty> findById(Long id) {
        return facultyRepository.findById(id);
    }

    // Guardar una nueva facultad
    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    // Eliminar una facultad por ID
    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
    }
}
