package Demo.Bug.Tracker.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.Bug.Tracker.Repository.BugRepository;
import Demo.Bug.Tracker.Repository.MessageRepository;
import Demo.Bug.Tracker.Repository.UsersRepository;
import Demo.Bug.Tracker.exception.BugNotFoundException;
import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Message;
import Demo.Bug.Tracker.model.Users;

@Service
public class UsersService {
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	BugRepository bugRepository;

	@Autowired
	MessageRepository messageRepository;
	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

	//user login
	public Users loginUser(int userId, String password) {
		Users user = null;
		if (usersRepository.existsById(userId)
				&& usersRepository.findById(userId).get().getUserPassword().equals(password)) {
			user = usersRepository.findById(userId).get();
			LOG.info("Admin login is  successfull");
		}
		return user;
	}

	// User Funtionalities on bugs
	//To add bug by user
	public Bug addBug(Bug bug) {
		LOG.info("Add bug");
		try {
		return bugRepository.save(bug);
		}catch(IllegalArgumentException iae) {
			LOG.error("Not able to add bug"+iae.getMessage());
			return null;
		}
	}

	//To update bug by user
	public Bug updateBugById(Bug bugId) {
		LOG.info("update bug by ID");
		try {
		return bugRepository.save(bugId);
		}catch(IllegalArgumentException iae) {
			LOG.error("Not able to update bug"+iae.getMessage());
			return null;
		}
	}

	//To delete bug by user
	public int deleteBugById(int bugId) {
		LOG.info("Delete bug");
		try {
		bugRepository.deleteById(bugId);
		return bugId;
		}catch(IllegalArgumentException iae) {
			LOG.error("Not able to delete bug"+iae.getMessage());
			return 0;
		}
	}
	
	// search bugs by bug Id
	public Bug searchBugByBugId(int bugId) {
        LOG.info("searchBugById " + bugId);
        Optional<Bug> optBug = bugRepository.findById(bugId);
        if (optBug.isEmpty()) {
            LOG.error("Bug not found.");
            throw new BugNotFoundException("Bug ID is not valid");
        } else
            return optBug.get();
    }

	// Message Functionalities
	//To view message by user
	public List<Message> getMessage() {
		LOG.info("get messages");
		return (List<Message>) messageRepository.findAll();
	}

	//To delete message by user
	public int deleteMessageById(int messageId) {
		LOG.info("delete Message");
		try {
		messageRepository.deleteById(messageId);
		return messageId;
		}catch(IllegalArgumentException iae) {
			LOG.error("Not able to delete "+iae.getMessage());
			return 0;
		}
	}


}
