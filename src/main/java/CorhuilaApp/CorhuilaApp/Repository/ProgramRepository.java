package CorhuilaApp.CorhuilaApp.Repository;

import CorhuilaApp.CorhuilaApp.Entity.AcademicProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramRepository extends JpaRepository<AcademicProgram, Long> {
    Optional<AcademicProgram> findByName(String name);

    List<AcademicProgram> findByNameContaining(String partialName);
}
