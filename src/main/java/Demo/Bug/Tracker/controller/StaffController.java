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

import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.model.Report;
import Demo.Bug.Tracker.service.AdministratorService;
import Demo.Bug.Tracker.service.StaffService;

@CrossOrigin
@RestController
public class StaffController {

	@Autowired
	StaffService staffService;

	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);
	
	//Report tasks for report
	@PostMapping("/report/AddProjectReport")
	public Report addProjectReport(@RequestBody Report report) {
		LOG.info("addProjectReport");
		return staffService.addProjectReport(report);
	}
	
	@PutMapping("/report/updateReport/{projectID}")
	public Report updateReport(@RequestBody Report projectID) {
		return staffService.updateReport(projectID);
	}
	
	@DeleteMapping("/Report/deleteReport/{reportId}") //InvalidId
    public int deleteReport(@PathVariable int reportId){
        LOG.info("deleteProject");
        return staffService.deleteReport(reportId);
    }
//	@GetMapping("/report/searchCompletedProjectReport")
//    public ResponseEntity<Report> searchCompletedProjectReport(@PathVariable Report status) {
//        LOG.info("View status");
//        Report report = staffService.searchCompletedProjectReportById(status);
//        return new ResponseEntity<Report>(report, HttpStatus.OK);
//    }
}