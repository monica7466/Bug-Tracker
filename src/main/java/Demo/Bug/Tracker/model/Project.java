package Demo.Bug.Tracker.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import io.swagger.annotations.Scope;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectID;

	@Column(name = "project_name", length = 50)
//    @Size(min = 1, max = 40, message = "Name must have between {min} and {max} characters.")
//    @NotNull(message = "A name is required for employee.")
	private String projectName;

	@JoinColumn(name = "BUG_ID", nullable = false)
	private int bugId;

	@Column(name = "start_date_of_project", length = 50)
//    @Size(min = 1, max = 40, message = "Name must have between {min} and {max} characters.")
//    @NotNull(message = "A name is required for employee.")
	private String startDateOfProject;

	@Column(name = "end_date_of_project", length = 50)
//    @Size(min = 1, max = 40, message = "Name must have between {min} and {max} characters.")
//    @NotNull(message = "A name is required for employee.")
	private String endDateOfProject;

	@JoinColumn(name = "STAFF_ID", nullable = false)
	private int staffId;

	@Column(name = "project_priority")
//    @Size(min = 1, max = 40, message = "Name must have between {min} and {max} characters.")
//    @NotNull(message = "A name is required for employee.")
	private int projectPriority;

	public Project() {
	}

	public Project(int projectID, String projectName, int bugId, String startDateOfProject, String endDateOfProject,
			int staffId, String projectStatus, int projectPriority) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.bugId = bugId;
		this.startDateOfProject = startDateOfProject;
		this.endDateOfProject = endDateOfProject;
		this.staffId = staffId;
		this.projectPriority = projectPriority;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public String getStartDateOfProject() {
		return startDateOfProject;
	}

	public void setStartDateOfProject(String startDateOfProject) {
		this.startDateOfProject = startDateOfProject;
	}

	public String getEndDateOfProject() {
		return endDateOfProject;
	}

	public void setEndDateOfProject(String endDateOfProject) {
		this.endDateOfProject = endDateOfProject;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getProjectPriority() {
		return projectPriority;
	}

	public void setProjectPriority(int projectPriority) {
		this.projectPriority = projectPriority;
	}

	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", projectName=" + projectName + ", bugId=" + bugId
				+ ", startDateOfProject=" + startDateOfProject + ", endDateOfProject=" + endDateOfProject + ", staffId="
				+ staffId + ", projectPriority=" + projectPriority + "]";
	}

}