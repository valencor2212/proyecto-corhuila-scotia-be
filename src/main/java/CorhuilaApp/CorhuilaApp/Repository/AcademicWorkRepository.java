package CorhuilaApp.CorhuilaApp.Repository;

import CorhuilaApp.CorhuilaApp.Entity.AcademicWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AcademicWorkRepository extends JpaRepository<AcademicWork, Long> {

    List<AcademicWork> findAllByTeacherId(Long teacherId);



}
