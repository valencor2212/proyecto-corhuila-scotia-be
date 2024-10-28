package CorhuilaApp.CorhuilaApp.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CorhuilaApp.CorhuilaApp.Entity.Teachers;
import CorhuilaApp.CorhuilaApp.Services.FacultyService;
import CorhuilaApp.CorhuilaApp.Services.PeriodService;
import CorhuilaApp.CorhuilaApp.Services.ProgramService;
import CorhuilaApp.CorhuilaApp.Services.TeachersService;
import CorhuilaApp.auxClass.TeacherInfoDTO;
import CorhuilaApp.auxClass.TeacherRegistrationRequest;
import CorhuilaApp.CorhuilaApp.security.JwtTokenUtil;

@RestController
@CrossOrigin
@RequestMapping("/api/teachers")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private ProgramService programService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private PeriodService periodService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<Teachers> registerTeachers(@RequestBody TeacherRegistrationRequest request) {
        try {
            Teachers newTeacher = new Teachers();
            newTeacher.setUsername(request.getUsername());
            newTeacher.setPassword(request.getPassword());
            newTeacher.setNombre(request.getNombre());

            // Establecer relaciones
            newTeacher.setAcademicProgram(programService.findById(request.getProgramId()).orElse(null));
            newTeacher.setFaculty(facultyService.findById(request.getFacultyId()).orElse(null));
            newTeacher.setAcademicPeriod(periodService.findById(request.getAcademicPeriodId()).orElse(null));

            // Guardar el profesor en la base de datos
            Teachers registeredTeacher = teachersService.register(newTeacher);
            return ResponseEntity.ok(registeredTeacher);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para autenticar un profesor
    @PostMapping("/login")
    public ResponseEntity<?> authenticateTeacher(@RequestBody TeacherRegistrationRequest loginData) {
        Optional<Teachers> teachers = teachersService.authenticate(loginData.getUsername(),
                loginData.getPassword());
        if (teachers.isPresent()) {
            // Generar el token JWT
            String token = jwtTokenUtil.generateToken(loginData.getUsername());
            return ResponseEntity.ok(new AuthResponse(token, teachers.get().getUsername(), teachers.get().getNombre()));
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    // Endpoint para obtener un profesor por ID
    @GetMapping("/{id}")
    public ResponseEntity<TeacherInfoDTO> getTeacherById(@PathVariable Long id) {
        Optional<Teachers> teacher = teachersService.getTeachersById(id);
        if (teacher.isPresent()) {
            Teachers t = teacher.get();
            TeacherInfoDTO dto = new TeacherInfoDTO(
                    t.getId(),
                    t.getUsername(),
                    t.getNombre(),
                    t.getFaculty() != null ? t.getFaculty().getName() : "N/A",
                    t.getAcademicProgram() != null ? t.getAcademicProgram().getName() : "N/A",
                    t.getAcademicPeriod() != null ? t.getAcademicPeriod().getName() : "N/A",
                    t.getJoinDate());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    static class AuthResponse {
        private String token;
        private String username;
        private String nombre;

        public AuthResponse(String token, String username, String nombre) {
            this.token = token;
            this.username = username;
            this.nombre = nombre;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
}