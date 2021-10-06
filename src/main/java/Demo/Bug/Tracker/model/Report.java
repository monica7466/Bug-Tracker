package Demo.Bug.Tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPORT")
public class Report {

	@Id
	@Column(name = "REPORT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportId;

//	@JoinColumn(name = "project_id", nullable = false)
//	private int projectId;
//
//	@JoinColumn(name = "project_name", nullable = false)
//	private String projectName;

	@Column(name = "SOLUTION_DESCRIPTION")
	private String solutionDescription;

	@Column(name = "STATUS")
	private String status;

	@OneToOne
	@JoinColumn(name="project_id")
	Project project;

	public Report() {

	}

//	public Report(int reportId, int projectId, String projectName, String solutionDescription, String status) {
//		super();
//		this.reportId = reportId;
//		this.projectId = projectId;
//		this.projectName = projectName;
//		this.solutionDescription = solutionDescription;
//		this.status = status;
//	}

	public Report(int reportId, String solutionDescription, String status, Project project) {
		super();
		this.reportId = reportId;
		this.solutionDescription = solutionDescription;
		this.status = status;
		this.project = project;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

//	public int getProjectId() {
//		return projectId;
//	}
//
//	public void setProjectId(int projectId) {
//		this.projectId = projectId;
//	}
//
//	public String getProjectName() {
//		return projectName;
//	}
//
//	public void setProjectName(String projectName) {
//		this.projectName = projectName;
//	}

	public String getSolutionDescription() {
		return solutionDescription;
	}

	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", solutionDescription=" + solutionDescription + ", status=" + status
				+ ", project=" + project + "]";
	}

//	@Override
//	public String toString() {
//		return "Report [reportId=" + reportId + ", projectId=" + projectId + ", projectName=" + projectName
//				+ ", solutionDescription=" + solutionDescription + ", status=" + status + "]";
//	}
	


}	