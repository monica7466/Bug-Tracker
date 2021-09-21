package Demo.Bug.Tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
