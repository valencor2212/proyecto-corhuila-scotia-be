package CorhuilaApp.CorhuilaApp.Services;

import CorhuilaApp.CorhuilaApp.Entity.AcademicWork;
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

    public Optional<AcademicWork> FindById(Long Id) {
        return workRepository.findById(Id);
    }

    public AcademicWork save(AcademicWork academicWork) {
        return workRepository.save(academicWork);
    }

    public Optional<AcademicWork> findByWorkName(String name) {
        return workRepository.findByname(name);
    }

}
