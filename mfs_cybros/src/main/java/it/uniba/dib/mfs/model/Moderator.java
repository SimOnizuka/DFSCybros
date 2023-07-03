package it.uniba.dib.mfs.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "moderators")
public class Moderator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "enter email")
	@Email(message = "enter email valida")
	private String emailString;
	
	@NotBlank(message = "enter password")
	@Length(min = 6, max = 14, message = "min 6 caratteri e max 14")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$", 
	message =  "The password must contain at least one lowercase letter, one uppercase letter, and one number.")
	private String passwordString;
	
	@NotBlank(message = "enter Name")
	private String nameString;
	
	@NotBlank(message = "enter Surname")
	private String surnameString;
	
	@NotBlank(message = "enter city of birth")
	private String cityOfBirth; 
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "La data deve essere nel passato")
	private LocalDate dateOfBirth;
	
	public Moderator () {
		super();
	}
	
	public Moderator(long id,
			String emailString,
			String passwordString,
			String nameString,
			String surnameString,
			String cityOfBirth,
			LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.emailString = emailString;
		this.passwordString = passwordString;
		this.nameString = nameString;
		this.surnameString = surnameString;
		this.cityOfBirth = cityOfBirth;
		this.dateOfBirth = dateOfBirth;
	}

	public Moderator (String emailString, String passwordString) {
		super();
		this.emailString = emailString;
		this.passwordString = passwordString;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getSurnameString() {
		return surnameString;
	}

	public void setSurnameString(String surnameString) {
		this.surnameString = surnameString;
	}

	public String getCityOfBirth() {
		return cityOfBirth;
	}

	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
