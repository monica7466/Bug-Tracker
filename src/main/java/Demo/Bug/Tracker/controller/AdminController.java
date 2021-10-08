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

import Demo.Bug.Tracker.exception.InvalidFieldException;
import Demo.Bug.Tracker.exception.NoSuchProjectStaffBugReportExceptionToDelete;
import Demo.Bug.Tracker.exception.NoSuchProjectStaffBugReportExceptionToUpdate;
import Demo.Bug.Tracker.exception.NoSuchRecordException;
import Demo.Bug.Tracker.exception.ProjectNotFoundException;
import Demo.Bug.Tracker.exception.ReportNotFoundException;
import Demo.Bug.Tracker.exception.StaffNotFoundException;
import Demo.Bug.Tracker.exception.BugNotFoundException;
import Demo.Bug.Tracker.exception.IncorrectLoginCredentialsException;

//import  Demo.Bug.Tracker.service.AdministratorService;

import Demo.Bug.Tracker.model.Administrator;
import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Message;
import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.model.Report;
import Demo.Bug.Tracker.model.Staff;
import Demo.Bug.Tracker.service.AdministratorService;

@CrossOrigin
@RestController
public class AdminController {
	@Autowired
	AdministratorService adminService;

	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

	// Admin Login
	@PostMapping(path = "/AdminLogin")
	public ResponseEntity<Administrator> adminLogin(@RequestBody Administrator admin)
			throws IncorrectLoginCredentialsException {
		Administrator result = adminService.loginAdmin(admin.getAdminId(), admin.getAdminPassword());
		ResponseEntity<Administrator> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	@GetMapping("/")
	public String index() {
		System.out.println("index");
		return "index";
	}

	// to add project by admin
	// http://localhost:8080/Project/addProject
	@PostMapping("/Project/addProject")
	public Project addProject(@RequestBody Project project) throws InvalidFieldException {
		LOG.info("addProject");
		return adminService.addProject(project);
	}

	// view all project to admin
	// http://localhost:8082/Project/getAllProject
	@GetMapping("/Project/getAllProject")
	public List<Project> getAllProject() throws NoSuchRecordException {
		LOG.info("getAllProject");
		return adminService.getAllProject();
	}
	/**
	 * 
	 * @param adminId
	 * @return
	 * @throws ProjectNotFoundException
	 */
	// to search project by admin
	@GetMapping("/searchProject/{adminId}")
	public ResponseEntity<Project> searchProject(@PathVariable int adminId) throws ProjectNotFoundException {
		LOG.info("get Project");
		Project project = adminService.searchProjectById(adminId);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	// to updating the project using projectId by admin
	// http://localhost:8080/Project/updateProject
	@PutMapping("/Project/updateProject/{projectID}") // InvalidId
	public Project updateProjectById(@RequestBody Project projectID) throws NoSuchProjectStaffBugReportExceptionToUpdate {
		return adminService.updateProjectById(projectID);
	}

	// to deleting the project using projectId by admin
	// http://localhost:8080/Project/deleteProject{projectID}
	@DeleteMapping("/Project/deleteProject/{projectID}") // InvalidId
	public int deleteProject(@PathVariable int projectID) throws NoSuchProjectStaffBugReportExceptionToDelete {
		LOG.info("deleteProject");
		return adminService.deleteProject(projectID);
	}

	// STAFF tasks

	// add new staff member details
	@PostMapping("/staff/addNewStaff")
	public Staff addNewStaff(@RequestBody Staff staff) throws InvalidFieldException {
		return adminService.addNewStaff(staff);
	}

	// view all staff member details
	@GetMapping("/Staff/getAllStaff")
	public List<Staff> getAllStaff() throws NoSuchRecordException {
		System.out.println("getStaff");
		return adminService.getAllStaff();
	}

	// update new staff member details
	@PutMapping("/staff/updateStaff/{staffId}") //// InvalidStaffId
	public Staff updateStaffById(@RequestBody Staff staffId) throws NoSuchProjectStaffBugReportExceptionToUpdate {
		return adminService.updateStaffById(staffId);
	}

	// delete new staff member details
	@DeleteMapping("/staff/deleteStaffById/{staffId}") /// InvalidStaffId
	public Staff deleteStaffById(@PathVariable Staff staffId) throws NoSuchProjectStaffBugReportExceptionToDelete {
		return adminService.deleteStaff(staffId);
	}

	// search staff by Id
	@GetMapping("/Staff/searchStaff{staffId}")
	public ResponseEntity<Staff> searchStaff(@PathVariable int staffId) throws StaffNotFoundException {
		LOG.info("Search bugs by id");
		Staff staff = adminService.searchStaffById(staffId);
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);
	}

	// BUGS tasks
	// To view all bugs to admin
	@GetMapping("/bug/getAllbugs")
	public List<Bug> getAllBugs() throws NoSuchRecordException {
		System.out.println("get all bugs");
		return adminService.getAllBugs();
	}

	// to search bug using bugId by admin
	@GetMapping("/Bug/searchBug{bugId}")
	public ResponseEntity<Bug> searchBug(@PathVariable int bugId) throws BugNotFoundException {
		LOG.info("Search bugs by id");
		Bug bug = adminService.searchBugById(bugId);
		return new ResponseEntity<Bug>(bug, HttpStatus.OK);
	}

	// message operations
	// send message to users
	@PostMapping("/message/addMessage")
	public Message addMessage(@RequestBody Message message) throws InvalidFieldException {
		return adminService.addMessage(message);
	}

	// REPORT TASK
	// view all reports
	@GetMapping("/Report/getAllReports")
	public List<Report> getAllReports() throws NoSuchRecordException {
		System.out.println("get all bugs");
		return adminService.getAllReports();
	}

}
