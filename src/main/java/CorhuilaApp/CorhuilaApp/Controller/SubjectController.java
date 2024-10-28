package CorhuilaApp.CorhuilaApp.Controller;

import CorhuilaApp.CorhuilaApp.Entity.Subject;
import CorhuilaApp.CorhuilaApp.Services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    // Obtener todas las asignaturas
    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.findAll();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    // Crear o actualizar una asignatura
    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject newSubject = subjectService.save(subject);
        return new ResponseEntity<>(newSubject, HttpStatus.CREATED);
    }

    // Eliminar una asignatura por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
