package CorhuilaApp.CorhuilaApp.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import CorhuilaApp.CorhuilaApp.Entity.Teachers;
import CorhuilaApp.CorhuilaApp.Repository.TeachersRepository;

import java.time.LocalDate;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Teachers register(Teachers teacher) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacher.setJoinDate(LocalDate.now()); // Establecer la fecha actual como la fecha de vinculación
        return teachersRepository.save(teacher);
    }

    // Obtener profesor por ID
    public Optional<Teachers> getTeachersById(Long id) {
        return teachersRepository.findById(id);
    }

    // Buscar profesor por nombre de usuario
    public Optional<Teachers> findByUsername(String username) {
        return teachersRepository.findByUsername(username);
    }

    // Autenticación de profesor (solo verificar username y password)
    public Optional<Teachers> authenticate(String username, String password) {
        Optional<Teachers> teacher = findByUsername(username);
        if (teacher.isPresent() && passwordEncoder.matches(password, teacher.get().getPassword())) {
            return teacher;
        }
        return Optional.empty();
    }
}
