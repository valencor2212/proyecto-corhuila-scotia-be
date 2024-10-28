package CorhuilaApp.CorhuilaApp.Controller;

import CorhuilaApp.CorhuilaApp.Entity.Group;
import CorhuilaApp.CorhuilaApp.Entity.Subject;
import CorhuilaApp.CorhuilaApp.Services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    // Obtener todos los grupos
    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.findAll();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    // Crear o actualizar un grupo
    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Group newGroup = groupService.save(group);
        return new ResponseEntity<>(newGroup, HttpStatus.CREATED);
    }

    // Obtener grupos por asignatura
    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<Group>> getGroupsBySubject(@PathVariable Long subjectId) {
        Subject subject = new Subject(); // Crear la instancia del subject con el ID proporcionado
        subject.setId(subjectId);
        List<Group> groups = groupService.findBySubject(subject);
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    // Eliminar un grupo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
