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
import Demo.Bug.Tracker.exception.ProjectNotFoundException;
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
	public Staff loginStaff(int staffId, String password) {
		Staff staff = null;
		if (staffRepository.existsById(staffId)
				&& staffRepository.findById(staffId).get().getStaffPassword().equals(password)) {
			staff = staffRepository.findById(staffId).get();
			// Logger.info("Admin login is successfull");
		}
		return staff;
	}

	// view assigned project by staff id
	public Project ViewAssignedProjectByStaffID(int staffId) {
		LOG.info("ViewAssignedProjectByStaffID " + staffId);
		Optional<Project> optProj = projectRepository.findById(staffId);
		if (optProj.isEmpty()) {
			LOG.error("Staff not Found");
			throw new ProjectNotFoundException("Please enter correct staff ID");
		} else
			return optProj.get();
	}

	// To add project Report by staff
	public Report addProjectReport(Report report) {
		LOG.info("Add report");
		try {
			return reportRepository.save(report);
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to add project report" + iae.getMessage());
			return null;
		}
	}

	// To update project Report by staff
	public Report updateReport(Report projectID) {
		LOG.info("update report by Project ID");
		try {
			return reportRepository.save(projectID);
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to update project report " + iae.getMessage());
			return null;
		}
	}

	// To delete project Report by staff
	public int deleteReport(int reportId) {
		LOG.info("deleteProject");
		try {
			reportRepository.deleteById(reportId);
			return reportId;
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to delete project report" + iae.getMessage());
			return 0;
		}
	}

	// PROJECT Functionalities FOR STAFF

	// view all staff
	public List<Staff> viewAllStaff() {
		LOG.info("viewAllStaff");
		return (List<Staff>) staffRepository.findAll();

	}
	// assign projects to other staff using staff Id
	public Project AssignProjectToOtherStaffUsingID(Project staffId) {
		LOG.info("updateProject by id");
		try {
			return projectRepository.save(staffId);
		} catch (IllegalArgumentException iae) {
			LOG.error("Not able to assign project to other staff using id " + iae.getMessage());
			return null;
		}
	}

	public Report searchReportByProjectID(int projectID) {
		LOG.info("searchReportByProjectID " + projectID);
		Optional<Report> optreport = reportRepository.findById(projectID);
		if (optreport.isEmpty()) {
			LOG.error("Bug not found.");
			throw new ProjectNotFoundException("Not able to search report by project ID");
		} else
			return optreport.get();
	}

	// view all report
	public List<Report> getAllReport() {
		LOG.info("Get all Report");
		return (List<Report>) reportRepository.findAll();
	}



}
