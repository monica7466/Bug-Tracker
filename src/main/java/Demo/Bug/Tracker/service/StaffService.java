package Demo.Bug.Tracker.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Demo.Bug.Tracker.Repository.ProjectRepository;
import Demo.Bug.Tracker.Repository.ReportRepository;
import Demo.Bug.Tracker.Repository.StaffRepository;
import Demo.Bug.Tracker.exception.IncorrectLoginCredentialsException;
import Demo.Bug.Tracker.exception.InvalidFieldException;
import Demo.Bug.Tracker.exception.NoSuchProjectStaffBugReportExceptionToDelete;
import Demo.Bug.Tracker.exception.NoSuchProjectStaffBugReportExceptionToUpdate;
import Demo.Bug.Tracker.exception.NoSuchRecordException;

import Demo.Bug.Tracker.exception.ProjectNotFoundException;
import Demo.Bug.Tracker.exception.ReportNotFoundException;
import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.model.Report;
import Demo.Bug.Tracker.model.Staff;

@Service
public class StaffService {
	@Autowired
	ReportRepository reportRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	StaffRepository staffRepository;

	// Report tasks for staff
	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

	// LOGIN
	public Staff loginStaff(int staffId, String password) throws IncorrectLoginCredentialsException{
		Staff staff = null;
		if (staffRepository.existsById(staffId)
				&& staffRepository.findById(staffId).get().getStaffPassword().equals(password)) {
			staff = staffRepository.findById(staffId).get();
			LOG.info("Staff login is successfull");
		}else {
			throw new IncorrectLoginCredentialsException("Invalid Credentials");
		}
		return staff;
	}

	// view assigned project by staff id
	public Project ViewAssignedProjectByStaffID(int staffId) throws ProjectNotFoundException {
		LOG.info("ViewAssignedProjectByStaffID " + staffId);
		Optional<Project> optProj = projectRepository.findById(staffId);
		if (optProj.isEmpty()) {
			LOG.error("Staff not Found");
			throw new ProjectNotFoundException("Please enter correct staff ID");
		} else
			return optProj.get();
	}

	// To add project Report by staff
	public Report addProjectReport(Report report) throws InvalidFieldException{
		LOG.info("Add report");
		if (!report.getSolutionDescription().isEmpty() && !report.getStatus().isEmpty()) {
			return reportRepository.save(report);
		} 
		    LOG.error("Fields are empty" );
			throw new InvalidFieldException("Fields are Empty");
	}

	// To update project Report by staff
	public Report updateReport(Report projectID) throws NoSuchProjectStaffBugReportExceptionToUpdate{
		LOG.info("update report by Project ID");
		try {
			return reportRepository.save(projectID);
		} catch (NoSuchProjectStaffBugReportExceptionToUpdate iae) {
			LOG.error("Not able to update project report " + iae.getMessage());
			return null;
		}
	}

	// To delete project Report by staff
	public int deleteReport(int reportId) throws NoSuchProjectStaffBugReportExceptionToDelete {
		LOG.info("deleteProject");
		if(reportRepository.existsById(reportId)) {
			reportRepository.deleteById(reportId);
			return reportId;
		} 
		LOG.error("Given id does not exist to remove Report");
			throw new NoSuchProjectStaffBugReportExceptionToDelete("Given id does not exist to remove Report");
	}

	// PROJECT Functionalities FOR STAFF

	// view all staff
//	public List<Staff> viewAllStaff() {
//		LOG.info("viewAllStaff");
//		return (List<Staff>) staffRepository.findAll();
//
//	}
//	
	public List<Staff> viewAllStaff() throws NoSuchRecordException{
		List<Staff> staff = staffRepository.findAll();
		if (!staff.isEmpty()) {
		LOG.info("getAllStaff");
		return staff;
		}
		LOG.error("No List found");
		throw new NoSuchRecordException("No List found");
	}
	
	// assign projects to other staff using staff Id
	public Project AssignProjectToOtherStaffUsingID(Project staffId) throws NoSuchProjectStaffBugReportExceptionToDelete{
		LOG.info("updateProject by id");
		try {
			return projectRepository.save(staffId);
		} catch (NoSuchProjectStaffBugReportExceptionToDelete iae) {
			LOG.error("Not able to assign project to other staff using id " + iae.getMessage());
			return null;
		}
	}

	public Report searchReportByProjectID(int projectID) throws ReportNotFoundException {
		LOG.info("searchReportByProjectID " + projectID);
		Optional<Report> optreport = reportRepository.findById(projectID);
		if (optreport.isEmpty()) {
			LOG.error("Bug not found.");
			throw new ProjectNotFoundException("Not able to search report by project ID");
		} else
			return optreport.get();
	}

	// view all report
//	public List<Report> getAllReport() {
//		LOG.info("Get all Report");
//		return (List<Report>) reportRepository.findAll();
//	}
	
	public List<Report> getAllReports() throws ReportNotFoundException {
		List<Report> report = reportRepository.findAll();
		if (!report.isEmpty()) {
		LOG.info("getAllReports");
		return report;
		}
		LOG.error("No List found");
		throw new NoSuchRecordException("No List found");
	}



}
