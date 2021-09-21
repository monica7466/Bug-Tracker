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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "STAFF")
public class Staff {
	// private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STAFF_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String staffPassword;

	@Column(name = "USER_NAME")
	private String userName;

	public Staff() {

	}

	public Staff(int staffId, String staffPassword, String userName) {
		super();
		this.staffId = staffId;
		this.staffPassword = staffPassword;
		this.userName = userName;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffPassword=" + staffPassword + ", userName=" + userName + "]";
	}

	
}