package Demo.Bug.Tracker.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Demo.Bug.Tracker.model.Bug;

public interface BugRepository extends JpaRepository<Bug, Integer> {
//	public abstract List<Bug> findByBugId(int BugId);

}
