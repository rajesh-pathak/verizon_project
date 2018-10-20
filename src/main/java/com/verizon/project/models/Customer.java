package com.verizon.project.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.verizon.project.models.Gender;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerId;
	
	@NotEmpty(message="First Name cannot be empty")
	@Column(name="firstName")
	private String firstName;
	
	@NotEmpty(message="Last Name cannot be empty")
	@Column(name="lastName")
	private String lastName;
	
	@NotEmpty(message="Email-ID cannot be left empty")
	@Column(name="emailId")
	private String emailId;
	
	@NotEmpty(message="Gender can not be null")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Pattern(regexp="\\d{10}",message="mobile number can be ony 10 digits")
	@Column(name="phoneNo")
	private String phoneNo;
	
	@OneToOne(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Connection connection;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Bills> bills;
	
	public Customer() {
		
	}

	public Customer(@NotEmpty(message = "First Name cannot be empty") String firstName,
			@NotEmpty(message = "Last Name cannot be empty") String lastName,
			@NotEmpty(message = "Email-ID cannot be left empty") String emailId,
			@NotEmpty(message = "Gender can not be null") Gender gender,
			@Pattern(regexp = "\\d{10}", message = "mobile number can be ony 10 digits") String phoneNo,
			Connection connection, List<Bills> bills) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.connection = connection;
		this.bills = bills;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<Bills> getBills() {
		return bills;
	}

	public void setBills(List<Bills> bills) {
		this.bills = bills;
	}
	
	
	
	
	
	

}
