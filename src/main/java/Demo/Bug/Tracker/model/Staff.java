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

	@Column(name = "STAFF_NAME", length = 50)
	private String staffName;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String staffPassword;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber; // long

	public Staff() {

	}

	public Staff(int staffId, String staffName, String staffPassword, String userName, String role, String email,
			String contactNumber) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffPassword = staffPassword;
		this.userName = userName;
		this.role = role;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffPassword=" + staffPassword
				+ ", userName=" + userName + ", role=" + role + ", email=" + email + ", contactNumber=" + contactNumber
				+ "]";
	}

}