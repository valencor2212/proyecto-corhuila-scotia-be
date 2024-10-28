package CorhuilaApp.CorhuilaApp.Controller;

import CorhuilaApp.CorhuilaApp.Entity.AcademicWork;
import CorhuilaApp.CorhuilaApp.Services.WorkService;
import CorhuilaApp.auxClass.AcademicWorkDTO;
import CorhuilaApp.auxClass.DTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/Work")
public class WorkController {

    private final WorkService workService;

    // Registrar una nueva labor
    @PostMapping("/register")
    public ResponseEntity<AcademicWork> registerWork(@RequestBody AcademicWork academicWork) {
        AcademicWork registeredWork = workService.save(academicWork);
        return new ResponseEntity<>(registeredWork, HttpStatus.CREATED);
    }

    // Obtener una labor por ID
    @GetMapping("/{id}")
    public ResponseEntity<AcademicWorkDTO> getWorkById(@PathVariable Long id) {
        Optional<AcademicWork> work = workService.FindById(id);
        return work.map(w -> new ResponseEntity<>(DTOConverter.toAcademicWorkDTO(w), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Buscar una labor por nombre
    @GetMapping("/workname/{name}")
    public ResponseEntity<AcademicWork> findWorkByname(@PathVariable String name) {
        Optional<AcademicWork> work = workService.findByWorkName(name);
        return work.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener todas las labores
    @GetMapping("/findall")
    public ResponseEntity<List<AcademicWorkDTO>> GetWork() {
        List<AcademicWork> works = workService.getAll();
        List<AcademicWorkDTO> workDTOs = DTOConverter.toAcademicWorkDTOList(works);
        return new ResponseEntity<>(workDTOs, HttpStatus.OK);
    }

    // Actualizar una labor existente
    @PutMapping("/{id}")
    public ResponseEntity<AcademicWork> updateWork(@PathVariable Long id, @RequestBody AcademicWork updatedWork) {
        Optional<AcademicWork> existingWork = workService.FindById(id);
        if (existingWork.isPresent()) {
            AcademicWork workToUpdate = existingWork.get();
            // Actualizamos los campos de horas semanales y semestrales
            workToUpdate.setEstimatedWeeklyTime(updatedWork.getEstimatedWeeklyTime());
            workToUpdate.setEstimatedSemiannualTime(updatedWork.getEstimatedSemiannualTime());
            AcademicWork savedWork = workService.save(workToUpdate);
            return ResponseEntity.ok(savedWork);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
