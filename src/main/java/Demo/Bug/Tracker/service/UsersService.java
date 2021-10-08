package Demo.Bug.Tracker.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.Bug.Tracker.Repository.BugRepository;
import Demo.Bug.Tracker.Repository.MessageRepository;
import Demo.Bug.Tracker.Repository.ReportRepository;
import Demo.Bug.Tracker.Repository.UsersRepository;
import Demo.Bug.Tracker.exception.BugNotFoundException;
import Demo.Bug.Tracker.exception.IncorrectLoginCredentialsException;
import Demo.Bug.Tracker.exception.InvalidFieldException;
import Demo.Bug.Tracker.exception.NoSuchProjectStaffBugReportExceptionToDelete;
import Demo.Bug.Tracker.exception.NoSuchProjectStaffBugReportExceptionToUpdate;
import Demo.Bug.Tracker.exception.NoSuchRecordException;
import Demo.Bug.Tracker.exception.ProjectNotFoundException;
import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Message;
import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.model.Report;
import Demo.Bug.Tracker.model.Users;

@Service
public class UsersService {
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	BugRepository bugRepository;

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	ReportRepository reportRepository;
	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

	// user login
	public Users loginUser(int userId, String password) throws IncorrectLoginCredentialsException {
		Users user = null;
		if (usersRepository.existsById(userId)
				&& usersRepository.findById(userId).get().getUserPassword().equals(password)) {
			user = usersRepository.findById(userId).get();
			LOG.info("User login is  successfull");
		} else {
			throw new IncorrectLoginCredentialsException("Invalid Credentials");
		}
		return user;
	}

	// User Funtionalities on bugs
	// To add bug by user
	public Bug addBug(Bug bug) throws InvalidFieldException {
		LOG.info("Add bug");
		if (!bug.getBugName().isEmpty() && !bug.getDescription().isEmpty() && !bug.getRaisedDate().isEmpty()) {
			return bugRepository.save(bug);
		}
		LOG.error("Fields are empty");
		throw new InvalidFieldException("Fields are Empty");
	}

	// search bugs by bug Id
	public Bug searchBugByBugId(int bugId) throws BugNotFoundException {
		LOG.info("searchBugById " + bugId);
		Optional<Bug> optBug = bugRepository.findById(bugId);
		if (optBug.isEmpty()) {
			LOG.error("Bug not found.");
			throw new BugNotFoundException("Bug ID is not valid");
		} else
			return optBug.get();
	}

	// To update bug by user
	public Bug updateBugById(Bug bugId) throws NoSuchProjectStaffBugReportExceptionToUpdate {
		LOG.info("update bug by ID");
		try {
			return bugRepository.save(bugId);
		} catch (NoSuchProjectStaffBugReportExceptionToUpdate iae) {
			LOG.error("Bug with bug ID not found to update" + iae.getMessage());
			return null;
		}
	}

	// To delete bug by user
	public int deleteBugById(int bugId) throws NoSuchProjectStaffBugReportExceptionToDelete {
		LOG.info("deleteBug");
		if (bugRepository.existsById(bugId)) {
			bugRepository.deleteById(bugId);
			return bugId;
		}
		LOG.error("Given id does not exist to remove Bug");
		throw new NoSuchProjectStaffBugReportExceptionToDelete("Given id does not exist to remove Bug");

	}

	// Message Functionalities
	// To view message by user
	public List<Message> getMessage() throws NoSuchRecordException {
		List<Message> message = messageRepository.findAll();
		if (!message.isEmpty()) {
			LOG.info("getAllMessage");
			return message;
		}
		LOG.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

	public int deleteMessageById(int messageId) throws NoSuchProjectStaffBugReportExceptionToDelete {
		LOG.info("delete Message");
		if (messageRepository.existsById(messageId)) {
			messageRepository.deleteById(messageId);
			return messageId;
		}
		LOG.error("Given id does not exist to remove Message");
		throw new NoSuchProjectStaffBugReportExceptionToDelete("Given id does not exist to remove Message");

	}

	// Report Functionalities

	public Report searchReportByProjectIDForUser(int projectID) throws ProjectNotFoundException {
		LOG.info("searchReportByProjectID " + projectID);
		Optional<Report> optreport = reportRepository.findById(projectID);
		if (optreport.isEmpty()) {
			LOG.error("Bug not found.");
			throw new ProjectNotFoundException("Not able to search report by project ID");
		} else
			return optreport.get();
	}

}
