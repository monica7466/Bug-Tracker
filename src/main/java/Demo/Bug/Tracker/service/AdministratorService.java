package Demo.Bug.Tracker.service;

import Demo.Bug.Tracker.exception.InvalidFieldException;
import Demo.Bug.Tracker.exception.ProjectNotFoundException;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.Bug.Tracker.Repository.AdministratorRepository;
import Demo.Bug.Tracker.Repository.BugRepository;
import Demo.Bug.Tracker.Repository.MessageRepository;
import Demo.Bug.Tracker.Repository.ProjectRepository;
import Demo.Bug.Tracker.Repository.StaffRepository;
import Demo.Bug.Tracker.exception.IncorrectLoginCredentialsException;

//import com.capgemini.exception.IncorrectLoginCredentialsException;
//import com.capgemini.exception.InvalidFieldException;
//import Demo.Bug.Tracker.*;
import Demo.Bug.Tracker.model.Administrator;
import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Message;
import Demo.Bug.Tracker.model.Project;
//import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Staff;

@Service
public class AdministratorService {
	@Autowired
	StaffRepository staffRepository;

	@Autowired
	BugRepository bugRepository;

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	AdministratorRepository adminRepository;
	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

//  @Transactional
//  public boolean addAdmin(Administrator admin) throws InvalidFieldException {
//      if (admin.getAdminName() == null && admin.getAdminPassword() == null) {
//          boolean result = false;
//          String name = admin.getAdminName();
//          String regex = "^[A-Za-z ]+";
//          if (name.matches(regex)) {
//              admin = adminRepository.save(admin);
//              result = true;
//              LOG.info("Admin is added successfully");
//              return result;
//          }
//          LOG.error("incorrect details");
//          throw new InvalidFieldException("Not able to add admin record");
//      }
//      throw new InvalidFieldException("Fields are empty");
//  }

	public Administrator loginAdmin(int adminId, String password) {
		Administrator admin = null;
		if (adminRepository.existsById(adminId)
				&& adminRepository.findById(adminId).get().getAdminPassword().equals(password)) {
			admin = adminRepository.findById(adminId).get();
			// Logger.info("Admin login is successfull");
		}
		return admin;
	}

	// project tasks
	public List<Project> getAllProject() {
		LOG.info("getAllProject");
		return (List<Project>) projectRepository.findAll();
	}

	public Project searchProjectById(int pid) {
		LOG.info("getEmployeeById " + pid);
		Optional<Project> optProj = projectRepository.findById(pid);
		if (optProj.isEmpty()) {
			LOG.error("Employee not found.");
			throw new ProjectNotFoundException("");
		} else
			return optProj.get();
	}

	public Project addProject(Project project) {
		LOG.info("addProject");
		try {
			return projectRepository.save(project);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	public Project updateProjectById(Project projectID) {
		LOG.info("updateProject by id");
		return projectRepository.save(projectID);
	}

	public int deleteProject(int pid) { // pid = ProjectID
		LOG.info("deleteProject");
		projectRepository.deleteById(pid);
		return pid;
	}

	// staff tasks

	public List<Staff> getAllStaff() {
		LOG.info("get all Staff");
		return (List<Staff>) staffRepository.findAll();
	}

	public Staff addNewStaff(Staff staff) {
		LOG.info("Add staff");
		return staffRepository.save(staff);
	}

	public Staff updateStaffById(Staff staffId) {
		LOG.info("Update a staff detail");
		return staffRepository.save(staffId);
	}

	public Staff deleteStaff(Staff staffId) {
		LOG.info("Delete a staff");
		staffRepository.delete(staffId);
		return staffId;
	}

	//Bug tasks
	public List<Bug> getAllBugs() {
		LOG.info("Get all bugs");
		return (List<Bug>) bugRepository.findAll();
	}

//	public List<Bug> getSolutionById(Bug bugId) {
//		LOG.info("get solution by bugId");
//		return (List<Bug>) bugRepository.findAll();
//	}

	// viewBugById assignTask track sendMessages
	public Bug searchBugById(int bugId) {
		LOG.info("searchBugById " + bugId);
		Optional<Bug> optBug = bugRepository.findById(bugId);
		if (optBug.isEmpty()) {
			LOG.error("Bug not found.");
			throw new ProjectNotFoundException("");
		} else
			return optBug.get();
	}

	// message ops
	public Message addMessage(Message message) {
		LOG.info("Add message");
		return messageRepository.save(message);
	}

}
