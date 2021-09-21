package Demo.Bug.Tracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("Administrator")
//@Scope("prototype")
@Entity
@Table(name = "ADMINISTRATOR")
public class Administrator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ADMIN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;

	@Column(name = "ADMIN_NAME", length = 50)
	private String adminName;

	@Column(name = "ADMIN_PASSWORD")
	private String adminPassword;

	public Administrator() {

	}

	public Administrator(int adminId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Administrator [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ "]";
	}

}