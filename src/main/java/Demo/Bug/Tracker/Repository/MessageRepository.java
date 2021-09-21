package Demo.Bug.Tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Demo.Bug.Tracker.model.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>  {


}
