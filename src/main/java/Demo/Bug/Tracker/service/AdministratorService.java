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
import Demo.Bug.Tracker.exception.MessageNotFoundException;
import Demo.Bug.Tracker.exception.NoSuchProjectStaffBugReportExceptionToDelete;
import Demo.Bug.Tracker.exception.NoSuchProjectStaffBugReportExceptionToUpdate;
import Demo.Bug.Tracker.exception.NoSuchRecordException;

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

	public List<Project> getAllProject() throws NoSuchRecordException {
		List<Project> project = projectRepository.findAll();
		if (!project.isEmpty()) {
			LOG.info("getAllProject");
			return project;
		}
		LOG.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

	// Search project using projectId by admin
	public Project searchProjectById(int pid) throws ProjectNotFoundException {
		Optional<Project> optProj = projectRepository.findById(pid);
		if (optProj.isEmpty()) {
			LOG.error("Employee not found.");
			throw new ProjectNotFoundException("Not able to search Project");
		} else
			return optProj.get();
	}

	// Add project using projectId by admin
	public Project addProject(Project project) throws InvalidFieldException {

		if (project.getBugId() != 0 && !project.getEndDateOfProject().isEmpty() && !project.getProjectName().isEmpty()
				&& project.getProjectPriority() != 0 && project.getStaffId() != 0
				&& !project.getStartDateOfProject().isEmpty()) {
			LOG.info("Project is added");
			return projectRepository.save(project);
		} else {
			LOG.error("Fields are empty");
			throw new InvalidFieldException("Fields are empty");
		}
	}

	// Update project using projectId by admin
	public Project updateProjectById(Project projectID) throws NoSuchProjectStaffBugReportExceptionToUpdate {
		try {
			return projectRepository.save(projectID);
		} catch (NoSuchProjectStaffBugReportExceptionToUpdate iae) {
			LOG.error("Project with project ID not found to update" + iae.getMessage());
			return null;
		}
	}

	// Delete project using projectId by admin
	public int deleteProject(int pid) throws NoSuchProjectStaffBugReportExceptionToDelete { // pid = ProjectID
		if (projectRepository.existsById(pid)) {
			projectRepository.deleteById(pid);
			return pid;
		}
		LOG.error("Given id does not exist to remove Project");
		throw new NoSuchProjectStaffBugReportExceptionToDelete("Given id does not exist to remove Project");
	}

	// Staff Functionalities

	// To add new staff by admin
	public Staff addNewStaff(Staff staff) throws InvalidFieldException {
		if (!staff.getStaffPassword().isEmpty() && !staff.getUserName().isEmpty()) {
			LOG.info("Staff is added");
			return staffRepository.save(staff);
		}
		LOG.error("Fields are empty");
		throw new InvalidFieldException("Fields are empty");

	}

	// To view all staff by admin

	public List<Staff> getAllStaff() throws NoSuchRecordException {
		List<Staff> staff = staffRepository.findAll();
		if (!staff.isEmpty()) {
			LOG.info("getAllProject");
			return staff;
		}
		LOG.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

	// To update staff by admin
	public Staff updateStaffById(Staff staffId) throws NoSuchProjectStaffBugReportExceptionToUpdate {
		try {
			return staffRepository.save(staffId);
		} catch (NoSuchProjectStaffBugReportExceptionToUpdate iae) {
			LOG.error("Staff with staff ID not found to update" + iae.getMessage());
			return null;
		}
	}

	// To delete staff by admin
	public Staff deleteStaff(Staff staffId) throws NoSuchProjectStaffBugReportExceptionToDelete {
		try {
			staffRepository.delete(staffId);
			return staffId;
		} catch (NoSuchProjectStaffBugReportExceptionToDelete iae) {
			LOG.error("Given id does not exist to remove Staff");
			return null;
		}
	}

	// search staff using staff Id
	public Staff searchStaffById(int staffId) throws StaffNotFoundException {
		LOG.info("searchStaffById " + staffId);
		Optional<Staff> optStaff = staffRepository.findById(staffId);
		if (optStaff.isEmpty()) {
			LOG.error("Staff not found.");
			throw new StaffNotFoundException("Not able to search Staff");
		} else
			return optStaff.get();
	}

	// Bug Functionalities

	public List<Bug> getAllBugs() throws NoSuchRecordException {
		List<Bug> bug = bugRepository.findAll();
		if (!bug.isEmpty()) {
			LOG.info("getAllBugs");
			return bug;
		}
		LOG.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

	// search Bug By Id
	public Bug searchBugById(int bugId) throws BugNotFoundException {
		Optional<Bug> optBug = bugRepository.findById(bugId);
		if (optBug.isEmpty()) {
			LOG.error("Bug not found.");
			throw new BugNotFoundException("Not able to find Bug");
		} else
			return optBug.get();
	}

	// Message Functionalities

	// add message
	public Message addMessage(Message message) throws InvalidFieldException {
		if (!message.getMessages().isEmpty()) {
			return messageRepository.save(message);
		}
		LOG.error("Fields are empty");
		throw new InvalidFieldException("Fields are empty");

	}

	// Report Functionalities

	public List<Report> getAllReports() throws NoSuchRecordException {
		List<Report> report = reportRepository.findAll();
		if (!report.isEmpty()) {
			LOG.info("getAllReports");
			return report;
		}
		LOG.error("No List found");
		throw new NoSuchRecordException("No List found");
	}
}