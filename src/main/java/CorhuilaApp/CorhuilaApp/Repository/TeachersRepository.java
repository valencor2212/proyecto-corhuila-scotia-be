package CorhuilaApp.CorhuilaApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CorhuilaApp.CorhuilaApp.Entity.Teachers;

import java.util.Optional;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Long> {
    Optional<Teachers> findByUsername(String username);
}