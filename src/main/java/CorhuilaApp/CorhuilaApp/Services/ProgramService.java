package CorhuilaApp.CorhuilaApp.Services;

import CorhuilaApp.CorhuilaApp.Entity.AcademicProgram;
import CorhuilaApp.CorhuilaApp.Repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgramService {

    private final ProgramRepository programRepository;

    // Obtener todos los programas académicos
    public List<AcademicProgram> getAll() {
        return programRepository.findAll();
    }

    // Obtener un programa por su ID
    public Optional<AcademicProgram> findById(Long id) {
        return programRepository.findById(id);
    }

    // Guardar o actualizar un programa académico
    public AcademicProgram save(AcademicProgram academicProgram) {
        // Aquí podrías agregar validaciones adicionales antes de guardar
        return programRepository.save(academicProgram);
    }

    // Buscar un programa académico por su nombre exacto
    public Optional<AcademicProgram> findByProgramName(String name) {
        return programRepository.findByName(name);
    }

    // Buscar programas académicos que contengan cierto texto en su nombre
    public List<AcademicProgram> findProgramsByPartialName(String partialName) {
        return programRepository.findByNameContaining(partialName);
    }

    // Eliminar un programa académico por su ID
    public void deleteById(Long id) {
        programRepository.deleteById(id);
    }
}
