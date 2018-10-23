package com.verizon.telecom.model;

import java.time.LocalDate;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerId;
	
	@NotEmpty(message="userName can not be empty")
	@Size(min=5,max=15,message="userName must be of 5 to 15 chars")
	private String username;
	
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",message="password must have a digit must occur at least once,"
			+ " a lower case letter must occur at least once, "
			+ "an upper case letter must occur at least once,"
			+ " a special character must occur at least once,"
			+ " no whitespace allowed in the entire string, at least 6-20 characters")
	@NotEmpty(message="password can not be empty")
	@Size(min=5,max=15,message="password must be of 5 to 15 chars")
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotEmpty(message="firstName can not be empty")
	@Size(min=5,max=15,message="firstName must be of 5 to 15 chars")
	private String customerFirstName;
	
	
	@NotEmpty(message="lastName can not be empty")
	@Size(min=5,max=15,message="lastName must be of 5 to 15 chars")
	private String customerLastName;
	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="Date Of Birth can not be left blank")
	@Column(name="dob")
	private LocalDate customerDateOfBirth;
	
	
	@NotEmpty(message="Email Id can not be null")
	@Email(message="Invalid Email Id")
	private String emailId;
	
	//@NotEmpty(message="Mobile Number can not be null")
	@Pattern(regexp="\\d{10}",message="mobile number can be ony 10 digits")
	@Column(name="mno")
	private String customerMobileNumber;
	
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	//@OneToOne(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY) //two-way mapping to check retrieval
	
	@OneToMany(mappedBy="services",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<ServicesBought> services;
	
	

	public List<ServicesBought> getServices() {
		return services;
	}

	public void setServices(List<ServicesBought> services) {
		this.services = services;
	}

	public Customer() {
		//super();
	}

	

	public Customer(
			@NotEmpty(message = "userName can not be empty") @Size(min = 5, max = 15, message = "userName must be of 5 to 15 chars") String username,
			@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message = "password must have a digit must occur at least once, a lower case letter must occur at least once, an upper case letter must occur at least once, a special character must occur at least once, no whitespace allowed in the entire string, at least 6-20 characters") @NotEmpty(message = "password can not be empty") @Size(min = 5, max = 15, message = "password must be of 5 to 15 chars") String password,
			@NotEmpty(message = "firstName can not be empty") @Size(min = 5, max = 15, message = "firstName must be of 5 to 15 chars") String customerFirstName,
			@NotEmpty(message = "lastName can not be empty") @Size(min = 5, max = 15, message = "lastName must be of 5 to 15 chars") String customerLastName,
			@NotNull(message = "Date Of Birth can not be left blank") LocalDate customerDateOfBirth,
			@NotEmpty(message = "Email Id can not be null") @Email(message = "Invalid Email Id") String emailId,
			@Pattern(regexp = "\\d{10}", message = "mobile number can be ony 10 digits") String customerMobileNumber,
			Gender gender, List<ServicesBought> services) {
		super();
		this.username = username;
		this.password = password;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerDateOfBirth = customerDateOfBirth;
		this.emailId = emailId;
		this.customerMobileNumber = customerMobileNumber;
		this.gender = gender;
		this.services = services;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public LocalDate getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}

	public void setCustomerDateOfBirth(LocalDate customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public long getCustomerId() {
		return customerId;
	}
	
	
	
	
}
