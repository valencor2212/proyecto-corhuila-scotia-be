package CorhuilaApp.CorhuilaApp.Controller;

import CorhuilaApp.CorhuilaApp.Entity.AcademicProgram;
import CorhuilaApp.CorhuilaApp.Services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/programs")
@RestController
public class ProgramController {

    private final ProgramService programService;

    // Registrar un nuevo programa académico
    @SuppressWarnings("null")
    @PostMapping("/register")
    public ResponseEntity<AcademicProgram> registerProgram(@RequestBody AcademicProgram academicProgram) {
        try {
            AcademicProgram registeredProgram = programService.save(academicProgram);
            return new ResponseEntity<>(registeredProgram, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT); // En caso de que el programa ya exista
        }
    }

    // Obtener un programa por su ID
    @GetMapping("/{id}")
    public ResponseEntity<AcademicProgram> getProgramById(@PathVariable Long id) {
        Optional<AcademicProgram> program = programService.findById(id);
        return program.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Buscar un programa por nombre exacto
    @GetMapping("/name/{name}")
    public ResponseEntity<AcademicProgram> findProgramByName(@PathVariable String name) {
        Optional<AcademicProgram> program = programService.findByProgramName(name);
        return program.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AcademicProgram>> getAllPrograms() {
        List<AcademicProgram> programs = programService.getAll();
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

    // Eliminar un programa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
        programService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
