package Demo.Bug.Tracker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import Demo.Bug.Tracker.model.Administrator;
import Demo.Bug.Tracker.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
