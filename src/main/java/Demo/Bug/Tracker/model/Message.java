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

	public Message(int messageId, String messages) {
		super();
		this.messageId = messageId;
		this.messages = messages;

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

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messages=" + messages + "]";
	}

}
