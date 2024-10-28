package CorhuilaApp.CorhuilaApp.Controller;

import CorhuilaApp.CorhuilaApp.Entity.AcademicPeriod;
import CorhuilaApp.CorhuilaApp.Services.PeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/Period")
public class PeriodController {
    private final PeriodService periodService;

    @PostMapping("/register")
    public ResponseEntity<AcademicPeriod> registerPeriod(@RequestBody AcademicPeriod academicPeriod) {
        AcademicPeriod registeredPeriod = periodService.save(academicPeriod);
        return new ResponseEntity<>(registeredPeriod, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicPeriod> getPeriodById(@PathVariable Long id) {
        Optional<AcademicPeriod> period = periodService.findById(id);
        return period.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/periodname/{name}")
    public ResponseEntity<AcademicPeriod> findPeriodByname(@PathVariable String name) {
        Optional<AcademicPeriod> period = periodService.findByPeriodname(name);
        return period.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findall")
    public List<AcademicPeriod> GetPeriod() {
        return periodService.getAll();
    }

}
