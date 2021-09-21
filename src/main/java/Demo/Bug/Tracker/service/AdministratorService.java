//Add comments
package Demo.Bug.Tracker.service;

import Demo.Bug.Tracker.exception.InvalidFieldException;
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
import Demo.Bug.Tracker.exception.IncorrectLoginCredentialsException;

//import com.capgemini.exception.IncorrectLoginCredentialsException;
//import com.capgemini.exception.InvalidFieldException;
//import Demo.Bug.Tracker.*;
import Demo.Bug.Tracker.model.Administrator;
import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Message;
import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.model.Report;
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
	ReportRepository reportRepository;

	@Autowired
	AdministratorRepository adminRepository;
	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

	//Admin login
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

	//Search project using projectId by admin
	public Project searchProjectById(int pid) {
		LOG.info("getEmployeeById " + pid);
		Optional<Project> optProj = projectRepository.findById(pid);
		if (optProj.isEmpty()) {
			LOG.error("Employee not found.");
			throw new ProjectNotFoundException("");
		} else
			return optProj.get();
	}

	//Add project using projectId by admin
	public Project addProject(Project project) {
		LOG.info("addProject");
		try {
			return projectRepository.save(project);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	//Update project using projectId by admin
	public Project updateProjectById(Project projectID) {
		LOG.info("updateProject by id");
		return projectRepository.save(projectID);
	}

	//Delete project using projectId by admin
	public int deleteProject(int pid) { // pid = ProjectID
		LOG.info("deleteProject");
		projectRepository.deleteById(pid);
		return pid;
	}

	// staff tasks
	//To view all staff by admin
	public List<Staff> getAllStaff() {
		LOG.info("get all Staff");
		return (List<Staff>) staffRepository.findAll();
	}

	//To add new staff by admin
	public Staff addNewStaff(Staff staff) {
		LOG.info("Add staff");
		return staffRepository.save(staff);
	}

	//To update staff by admin
	public Staff updateStaffById(Staff staffId) {
		LOG.info("Update a staff detail");
		return staffRepository.save(staffId);
	}

	//To delete staff by admin
	public Staff deleteStaff(Staff staffId) {
		LOG.info("Delete a staff");
		staffRepository.delete(staffId);
		return staffId;
	}
	
	//search staff using staff Id
	public Staff searchStaffById(int staffId) {
        LOG.info("searchStaffById " + staffId);
        Optional<Staff> optStaff = staffRepository.findById(staffId);
        if (optStaff.isEmpty()) {
            LOG.error("Staff not found.");
            throw new StaffNotFoundException("Staff is not present in database");
        } else
            return optStaff.get();
    }

	//Bug tasks
	//to view all bugs by admin
	public List<Bug> getAllBugs() {
		LOG.info("Get all bugs");
		return (List<Bug>) bugRepository.findAll();
	}

	// search Bug By Id 
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
	//add message
	public Message addMessage(Message message) {
		LOG.info("Add message");
		return messageRepository.save(message);
	}

	//REPORT TASK
	//View all project reports
    public List<Report> getAllReports() {
        LOG.info("Get all bugs");
        return (List<Report>) reportRepository.findAll();
    }
}
