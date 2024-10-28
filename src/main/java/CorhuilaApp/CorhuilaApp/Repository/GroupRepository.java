package CorhuilaApp.CorhuilaApp.Repository;

import CorhuilaApp.CorhuilaApp.Entity.Group;
import CorhuilaApp.CorhuilaApp.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findBySubject(Subject subject);

    List<Group> findByGroupNumber(int groupNumber);
}
