package CorhuilaApp.CorhuilaApp.Services;

import CorhuilaApp.CorhuilaApp.Entity.Group;
import CorhuilaApp.CorhuilaApp.Entity.Subject;
import CorhuilaApp.CorhuilaApp.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    public List<Group> findBySubject(Subject subject) {
        return groupRepository.findBySubject(subject);
    }

    public List<Group> findByGroupNumber(int groupNumber) {
        return groupRepository.findByGroupNumber(groupNumber);
    }

    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }
}
