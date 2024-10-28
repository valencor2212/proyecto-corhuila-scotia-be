package CorhuilaApp.CorhuilaApp.Services;

import CorhuilaApp.CorhuilaApp.Entity.AcademicPeriod;
import CorhuilaApp.CorhuilaApp.Repository.PeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeriodService {
    private final PeriodRepository periodRepository;

    public List<AcademicPeriod> getAll() {
        return periodRepository.findAll();
    }

    public Optional<AcademicPeriod> findById(Long Id) {
        return periodRepository.findById(Id);
    }

    public AcademicPeriod save(AcademicPeriod academicPeriod) {
        return periodRepository.save(academicPeriod);
    }

    public Optional<AcademicPeriod> findByPeriodname(String name) {
        return periodRepository.findByname(name);
    }

}
