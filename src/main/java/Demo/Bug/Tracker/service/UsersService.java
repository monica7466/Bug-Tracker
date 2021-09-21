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

	public Users loginUser(int userId, String password) {
		Users user = null;
		if (usersRepository.existsById(userId)
				&& usersRepository.findById(userId).get().getUserPassword().equals(password)) {
			user = usersRepository.findById(userId).get();
			LOG.info("Admin login is  successfull");
		}
		return user;
	}

	// user tasks on bugs
	public Bug addBug(Bug bug) {
		LOG.info("Add bug");
		return bugRepository.save(bug);
	}

//	public Bug getBugById(Integer bugId) {
//		LOG.info("Get Bug by ID");
//		Optional<Bug> optBug = bugRepository.findById(bugId);
//		return optBug.get();
//	}
	public Bug updateBugById(Bug bugId) {
		LOG.info("update bug by ID");
		return bugRepository.save(bugId);
	}

	public int deleteBugById(int bugId) {
		LOG.info("delete bug");
		bugRepository.deleteById(bugId);
		return bugId;
	}

	// message tasks
	public List<Message> getMessage() {
		LOG.info("get messages");
		return (List<Message>) messageRepository.findAll();
	}

	public int deleteMessageById(int messageId) {
		LOG.info("delete Message");
		messageRepository.deleteById(messageId);
		return messageId;
	}

}
