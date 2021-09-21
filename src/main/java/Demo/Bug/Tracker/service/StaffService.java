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
import Demo.Bug.Tracker.model.Bug;
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

	 //LOGIN
    public Staff loginStaff(int staffId, String password) {  
        Staff staff =null;
       if (staffRepository.existsById(staffId)
               && staffRepository.findById(staffId).get().getStaffPassword().equals(password)) {
            staff = staffRepository.findById(staffId).get();
           //Logger.info("Admin login is  successfull");
       }
       return staff;
   }
    
  //To add project Report by staff
	public Report addProjectReport(Report report) {
		LOG.info("Add report");
		return reportRepository.save(report);
	}

	//To update project Report by staff
	public Report updateReport(Report projectID) {
		LOG.info("update report by Project ID");
		return reportRepository.save(projectID);
	}

	//To delete project Report by staff
	public int deleteReport(int reportId) {
		LOG.info("deleteProject");
		reportRepository.deleteById(reportId);
		return reportId;
	}
//	 public Report searchCompletedProjectReportById(Report status) {
//	        LOG.info("searchBugById " + status);
//	        Optional<Report> optReport = statusRepository.findById(status);
//	        if (optReport.isEmpty()) {
//	            LOG.info("Get status");
//	        } else
//	            return optReport.get();
//	    }
//	 public Report searchReportById(String status) {
//	        LOG.info("searchBugById " + status);
//	        List<Report> optBug = reportRepository.findByStatus(status);
//	        if (optBug.isEmpty()) {
//	            LOG.error("Bug not found.");
//	             } else
//	            return optBug.get(status);
//	    }

	//staff to staff tasks
	// PROJECT TASK FOR STAFF
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

	//assign projects to other staff using staff Id
    public Project AssignProjectToOtherStaffUsingID(Project projectID) {
        LOG.info("updateProject by id");
        return projectRepository.save(projectID);
    }

//	public Report searchReportByProjectId(int reportId) {
//		LOG.info("searchReportByProjectId " + reportId);
//		Optional<Report> optreport = reportRepository.findById(reportId);
//		if (optreport.isEmpty()) {
//			LOG.error("Bug not found.");
//			throw new ProjectNotFoundException("");
//		} else
//			return optreport.get();
//	}
    
    //view all report
    public List<Report> getAllReport() {
        LOG.info("Get all Report");
        return (List<Report>) reportRepository.findAll();
    }

    //view all staff
	public List<Staff> viewAllStaff() {
		LOG.info("viewAllStaff");
		return (List<Staff>) staffRepository.findAll();

	}
    
	}

