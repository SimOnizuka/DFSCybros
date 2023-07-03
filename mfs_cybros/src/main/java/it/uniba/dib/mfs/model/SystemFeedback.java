package it.uniba.dib.mfs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "systemFeedback")
public class SystemFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Email(message = "enter valid email!")
	private String userString;
	
	@Length(min = 10, message = "Inserisci un testo di almeno 10 caratteri")
	private String feedback;

	public SystemFeedback() {
		super();
	}

	public SystemFeedback(String userString, String feedback) {
		super();
		this.userString = userString;
		this.feedback = feedback;
	}

	public String getUserString() {
		return userString;
	}

	public void setUserString(String userString) {
		this.userString = userString;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public long getId() {
		return id;
	}

}
