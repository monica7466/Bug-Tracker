package Demo.Bug.Tracker.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Demo.Bug.Tracker.model.Administrator;
import Demo.Bug.Tracker.model.Report;

public interface ReportRepository extends  JpaRepository<Report, Integer>{
public abstract List<Report> findByStatus(String status);

//public abstract Optional<Report> findByStatus(Report status);

}
