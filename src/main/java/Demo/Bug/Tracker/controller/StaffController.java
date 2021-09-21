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
import Demo.Bug.Tracker.exception.ProjectNotFoundException;
import Demo.Bug.Tracker.exception.ReportNotFoundException;
import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.model.Report;
import Demo.Bug.Tracker.model.Staff;
import Demo.Bug.Tracker.service.AdministratorService;
import Demo.Bug.Tracker.service.StaffService;

@CrossOrigin
@RestController
public class StaffController {

	@Autowired
	StaffService staffService;

	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

	// LOGIN
	//Staff Login
	@PostMapping(path = "/StaffLogin")
	public ResponseEntity<Staff> staffLogin(@RequestBody Staff staff) throws IncorrectLoginCredentialsException {
		Staff result = staffService.loginStaff(staff.getStaffId(), staff.getStaffPassword());
		ResponseEntity<Staff> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	// Report tasks for report
	@PostMapping("/report/AddProjectReport")
	public Report addProjectReport(@RequestBody Report report) {
		LOG.info("addProjectReport");
		return staffService.addProjectReport(report);
	}

	//To update report by staff for admin and user
	@PutMapping("/report/updateReport/{projectID}")
	public Report updateReport(@RequestBody Report projectID) {
		return staffService.updateReport(projectID);
	}

	//To delete report by staff 
	@DeleteMapping("/Report/deleteReport/{reportId}") // InvalidId
	public int deleteReport(@PathVariable int reportId) {
		LOG.info("deleteProject");
		return staffService.deleteReport(reportId);
	}

	// Staff to staff tasks
	//Assign project to other staff
	// http://localhost:8080/Project/AssignProjectToOtherStaff
	@PutMapping("/Project/AssignProjectToOtherStaff/{projectID}") // InvalidId
	public Project AssignProjectToOtherStaff(@RequestBody Project projectID) throws NoSuchRecordException {
		return staffService.AssignProjectToOtherStaffUsingID(projectID);
	}

	//view all staff members
	@GetMapping("/Staff/viewAllStaff")
	public List<Staff> viewAllStaff() throws NoSuchRecordException {
		System.out.println("viewAllStaff");
		return staffService.viewAllStaff();
	}

	// view assigned project with staffId                         *****
	@GetMapping("/ViewAssignedProject/{staffId}")
	public ResponseEntity<Project> viewAssignedProject(@PathVariable int staffId) throws ProjectNotFoundException {
		LOG.info("get Project");
		Project project = staffService.ViewAssignedProjectByStaffID(staffId);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	// Report/ViewProjectReport(ByProjectID)
//    @GetMapping("/Report/searchReportByProjectId{projectId}")
//    public ResponseEntity<Report> searchBug(@PathVariable Integer reportId) throws ReportNotFoundException{
//        LOG.info("Search bugs by id");
//        Report report = staffService.searchReportByProjectId(reportId);
//        return new ResponseEntity<Report>(report, HttpStatus.OK);
//    }
	
	//view all reports by staff
	@GetMapping("/Report/getAllReport")
	public List<Report> getAllReport() throws NoSuchRecordException {
		System.out.println("get all bugs");
		return staffService.getAllReport();

	}

}