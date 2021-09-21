package Demo.Bug.Tracker.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.Bug.Tracker.Repository.ReportRepository;

import Demo.Bug.Tracker.model.Report;

@Service
public class StaffService {
	@Autowired
	ReportRepository reportRepository;

	// Report tasks for staff
	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

	public Report addProjectReport(Report report) {
		LOG.info("Add report");
		return reportRepository.save(report);
	}

	public Report updateReport(Report projectID) {
		LOG.info("update report by Project ID");
		return reportRepository.save(projectID);
	}

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

}
