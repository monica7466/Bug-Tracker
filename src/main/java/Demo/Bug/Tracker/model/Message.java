package Demo.Bug.Tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
public class Message {
	@Id
	@Column(name = "MESSAGE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;
	
	@Column(name = "MESSAGES", length = 100)
	private String messages;
	
	@JoinColumn(name = "USER_ID", nullable = false)
    private int userId;
	
	@JoinColumn(name = "ADMIN_ID", nullable = false)
    private int adminId;

	public Message(int messageId, String messages, int userId, int adminId) {
		super();
		this.messageId = messageId;
		this.messages = messages;
		this.userId = userId;
		this.adminId = adminId;
	}

	public Message() {
		super();
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messages=" + messages + ", userId=" + userId + ", adminId="
				+ adminId + "]";
	}
	
	
}
