package CorhuilaApp.CorhuilaApp.Services;

import CorhuilaApp.CorhuilaApp.Entity.AcademicWork;
import CorhuilaApp.CorhuilaApp.Entity.Teachers;
import CorhuilaApp.CorhuilaApp.Repository.AcademicWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class WorkService {

    private final AcademicWorkRepository workRepository;

    public List<AcademicWork> getAll() {
        return workRepository.findAll();
    }
    public Optional<AcademicWork> findById(Long id) {
        return workRepository.findById(id);
    }
    
    public List<AcademicWork> getAllByTeacher(Long teacherId) {
        return workRepository.findAllByTeacherId(teacherId);
    }
    
    public List<AcademicWork> getUpdatedWorksByTeacher(Long teacherId) {
        return workRepository.findAllByTeacherId(teacherId);
    }

   public AcademicWork save(AcademicWork academicWork, Teachers teacher) {
    academicWork.setTeacher(teacher);
    return workRepository.save(academicWork);
}
}
