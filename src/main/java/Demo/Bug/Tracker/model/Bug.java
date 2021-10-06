package Demo.Bug.Tracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BUG")
public class Bug implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BUG_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bugId;

	@Column(name = "BUG_NAME")
	private String bugName;

	@Column(name = "RAISED_DATE")
	private String raisedDate;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	Users users;

	public Bug() {
	}

//	public Bug(int bugId, String bugName, String raisedDate, String description) {
//		super();
//		this.bugId = bugId;
//		this.bugName = bugName;
//		this.raisedDate = raisedDate;
//		this.description = description;
//	}
	

	public int getBugId() {
		return bugId;
	}

	public Bug(int bugId, String bugName, String raisedDate, String description, Users users) {
		super();
		this.bugId = bugId;
		this.bugName = bugName;
		this.raisedDate = raisedDate;
		this.description = description;
		this.users = users;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public String getBugName() {
		return bugName;
	}

	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	public String getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(String raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Bug [bugId=" + bugId + ", bugName=" + bugName + ", raisedDate=" + raisedDate + ", description="
				+ description + ", users=" + users + "]";
	}

//	@Override
//	public String toString() {
//		return "Bug [bugId=" + bugId + ", bugName=" + bugName + ", raisedDate=" + raisedDate + ", description="
//				+ description + "]";
//	}
	
	

}