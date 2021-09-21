package Demo.Bug.Tracker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Demo.Bug.Tracker.exception.BugNotFoundException;
import Demo.Bug.Tracker.exception.IncorrectLoginCredentialsException;
import Demo.Bug.Tracker.exception.NoSuchRecordException;
import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Message;
import Demo.Bug.Tracker.model.Users;
import Demo.Bug.Tracker.service.AdministratorService;
import Demo.Bug.Tracker.service.UsersService;

@CrossOrigin
@RestController
public class UsersController {
	@Autowired
	UsersService usersService;

	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);
	
	//User Login
	@PostMapping(path = "/UsersLogin")
    public ResponseEntity<Users> usersLogin(@RequestBody Users user)
            throws IncorrectLoginCredentialsException{
        Users result = usersService.loginUser(user.getUserId(), user.getUserPassword());
        ResponseEntity<Users> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }
	
	//user tasks on bugs
	//add bug
	@PostMapping("/bug/addBug")
	public Bug addBug(@RequestBody Bug bug) throws NoSuchRecordException{
		return usersService.addBug(bug);
	}
	
	//search bugs by Id
	@GetMapping("/Bug/searchBugs{bugId}")
    public ResponseEntity<Bug> searchBugs(@PathVariable int bugId) throws BugNotFoundException{
        LOG.info("Search bugs by id");
        Bug bug = usersService.searchBugByBugId(bugId);
        return new ResponseEntity<Bug>(bug, HttpStatus.OK);
    }
	
	//To update bug using bugId by user
	@PutMapping("/bug/updateBug/{bugId}")
	public Bug updateBugById(@RequestBody Bug bugId) {
		return usersService.updateBugById(bugId);
	}
	
	//To delete bug using bugId by user
	@DeleteMapping("/bug/deleteBugById/{bugId}")
	public int deleteBugById(@PathVariable int bugId) {
		LOG.info("Delte bug");
		return usersService.deleteBugById(bugId);
	}
	
	//message tasks
	//view message
	@GetMapping("/message/getMessage")
	public List<Message> getMessage() {
		return usersService.getMessage();
	}
	
	//To delete message using messageId by user
	@DeleteMapping("/bug/deleteMessageById/{messageId}")
	public int deleteMessageById(@PathVariable int messageId) {
		LOG.info("Delete message");
		return usersService.deleteMessageById(messageId);
	}

}
