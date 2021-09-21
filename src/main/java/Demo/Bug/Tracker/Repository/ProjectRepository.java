package Demo.Bug.Tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Demo.Bug.Tracker.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}