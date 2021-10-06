package Demo.Bug.Tracker.service;

import Demo.Bug.Tracker.exception.ProjectNotFoundException;
import Demo.Bug.Tracker.exception.StaffNotFoundException;

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
import Demo.Bug.Tracker.Repository.ReportRepository;
import Demo.Bug.Tracker.Repository.StaffRepository;
import Demo.Bug.Tracker.exception.BugNotFoundException;
import Demo.Bug.Tracker.exception.IncorrectLoginCredentialsException;
import Demo.Bug.Tracker.exception.InvalidFieldException;
import Demo.Bug.Tracker.model.Administrator;
import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Message;
import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.model.Report;
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
	ReportRepository reportRepository;

	@Autowired
	AdministratorRepository adminRepository;
	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

	// Admin login
	public Administrator loginAdmin(int adminId, String password) throws IncorrectLoginCredentialsException {
		Administrator admin = null;
		if (adminRepository.existsById(adminId)
				&& adminRepository.findById(adminId).get().getAdminPassword().equals(password)) {
			admin = adminRepository.findById(adminId).get();
			LOG.info("Admin login is successfull");
		} else {
			throw new IncorrectLoginCredentialsException("Invalid Credentials");
		}
		return admin;
	}

	// Project Functionalities

	public List<Project> getAllProject() {
		LOG.info("getAllProject");
		return (List<Project>) projectRepository.findAll();
	}

	// Search project using projectId by admin
	public Project searchProjectById(int pid) {
		Optional<Project> optProj = projectRepository.findById(pid);
		if (optProj.isEmpty()) {
			LOG.error("Employee not found.");
			throw new ProjectNotFoundException("Not able to search Project");
		} else
			return optProj.get();
	}

	// Add project using projectId by admin
	public Project addProject(Project project) {
		
		if(project.getBugId()!=0) {
			LOG.info("Project is added");
			return projectRepository.save(project);
		}
		else {
			LOG.error("Project not added");
			throw new InvalidFieldException("Not able to add project");
		}
	}

	// Update project using projectId by admin
	public Project updateProjectById(Project projectID) {
		try {
			return projectRepository.save(projectID);
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to update Project" + iae.getMessage());
			return null;
		}
	}

	// Delete project using projectId by admin
	public int deleteProject(int pid) { // pid = ProjectID
		try {
			projectRepository.deleteById(pid);
			return pid;
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to delete Project" + iae.getMessage());
			return 0;
		}
	}

	// Staff Functionalities

	// To add new staff by admin
	public Staff addNewStaff(Staff staff) {
		try {
			return staffRepository.save(staff);
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to add Staff" + iae.getMessage());
			return null;
		}
	}

	// To view all staff by admin
	public List<Staff> getAllStaff() {
		LOG.info("get all Staff");
		return (List<Staff>) staffRepository.findAll();
	}

	// To update staff by admin
	public Staff updateStaffById(Staff staffId) {
		try {
			return staffRepository.save(staffId);
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to Update Staff" + iae.getMessage());
			return null;
		}
	}

	// To delete staff by admin
	public Staff deleteStaff(Staff staffId) {
		try {
			staffRepository.delete(staffId);
			return staffId;
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to delete Staff" + iae.getMessage());
			return null;
		}
	}

	// search staff using staff Id
	public Staff searchStaffById(int staffId) {
		LOG.info("searchStaffById " + staffId);
		Optional<Staff> optStaff = staffRepository.findById(staffId);
		if (optStaff.isEmpty()) {
			LOG.error("Staff not found.");
			throw new StaffNotFoundException("Not able to search Staff");
		} else
			return optStaff.get();
	}

	// Bug Functionalities

	// to view all bugs by admin
	public List<Bug> getAllBugs() {
		LOG.info("Get all bugs");
		return (List<Bug>) bugRepository.findAll();
	}

	// search Bug By Id
	public Bug searchBugById(int bugId) {
		Optional<Bug> optBug = bugRepository.findById(bugId);
		if (optBug.isEmpty()) {
			LOG.error("Bug not found.");
			throw new BugNotFoundException("Not able to find Bug");
		} else
			return optBug.get();
	}

	// Message Functionalities

	// add message
	public Message addMessage(Message message) {
		try {
			return messageRepository.save(message);
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to add Message" + iae.getMessage());
			return null;
		}
	}

	// Report Functionalities

	// View all project reports
	public List<Report> getAllReports() {
		LOG.info("Get all bugs");
		return (List<Report>) reportRepository.findAll();
	}
}