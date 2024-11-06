package CorhuilaApp.CorhuilaApp.Controller;

import CorhuilaApp.CorhuilaApp.Entity.AcademicWork;
import CorhuilaApp.CorhuilaApp.Entity.Teachers;
import CorhuilaApp.CorhuilaApp.Services.TeachersService;
import CorhuilaApp.CorhuilaApp.Services.WorkService;
import CorhuilaApp.auxClass.AcademicWorkDTO;
import CorhuilaApp.auxClass.DTOConverter;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
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
    
private TeachersService teachersService;

@Autowired
    public WorkController(WorkService workService, TeachersService teachersService) {
        this.workService = workService;
        this.teachersService = teachersService;
    }
    @PostMapping("/register")
    public ResponseEntity<AcademicWork> registerWork(@RequestBody AcademicWork academicWork, @RequestParam Long teacherId) {
        // Obtener el objeto Teachers a partir del teacherId
        Teachers teacher = teachersService.getTeachersById(teacherId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        // Llamar a save con ambos parámetros
        AcademicWork registeredWork = workService.save(academicWork, teacher);
        return new ResponseEntity<>(registeredWork, HttpStatus.CREATED);
    }


   
    @GetMapping("/{id}")
    public ResponseEntity<AcademicWorkDTO> getWorkById(@PathVariable Long id) {
        Optional<AcademicWork> work = workService.findById(id);
        return work.map(w -> new ResponseEntity<>(DTOConverter.toAcademicWorkDTO(w), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<AcademicWorkDTO>> getAllWorks() {
        List<AcademicWork> works = workService.getAll();
        List<AcademicWorkDTO> workDTOs = DTOConverter.toAcademicWorkDTOList(works);
        return new ResponseEntity<>(workDTOs, HttpStatus.OK);
    }

    @GetMapping("/updated-by-teacher")
    public ResponseEntity<List<AcademicWorkDTO>> getUpdatedWorksByTeacher(@RequestParam Long teacherId) {
        // Verificar si el teacherId es válido y obtener sus WORKS actualizados
        List<AcademicWork> updatedWorks = workService.getUpdatedWorksByTeacher(teacherId);
        
        // Convertir las entidades a DTOs
        List<AcademicWorkDTO> workDTOs = DTOConverter.toAcademicWorkDTOList(updatedWorks);
        
        return ResponseEntity.ok(workDTOs);
    }
    @PutMapping("/{id}")
public ResponseEntity<AcademicWork> updateWork(
        @PathVariable Long id,
        @RequestBody AcademicWork updatedWork,
        @RequestParam Long teacherId) {
    
    Optional<AcademicWork> existingWork = workService.findById(id);
    
    if (existingWork.isPresent()) {
        AcademicWork workToUpdate = existingWork.get();
        
        // Actualizamos las horas específicas
        workToUpdate.setEstimatedWeeklyTime(updatedWork.getEstimatedWeeklyTime());
        workToUpdate.setEstimatedSemiannualTime(updatedWork.getEstimatedSemiannualTime());
        
        // Asociar el trabajo al profesor específico
        Teachers teacher = teachersService.getTeachersById(teacherId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        
        AcademicWork savedWork = workService.save(workToUpdate, teacher);
        
        return ResponseEntity.ok(savedWork);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

}

