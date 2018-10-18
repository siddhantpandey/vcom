package com.vcom.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="servicesbought")
public class ServicesBought {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long serviceId;
	
	
	@OneToOne
	@JoinColumn(name="customerHolderId")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Services getServices() {
		return services;
	}


	public void setServices(Services services) {
		this.services = services;
	}


	public Plans getPlans() {
		return plans;
	}


	public void setPlans(Plans plans) {
		this.plans = plans;
	}


	public Packages getPackages() {
		return packages;
	}


	public void setPackages(Packages packages) {
		this.packages = packages;
	}


	public LocalDate getDateOfActivation() {
		return dateOfActivation;
	}


	public void setDateOfActivation(LocalDate dateOfActivation) {
		this.dateOfActivation = dateOfActivation;
	}


	public long getServiceId() {
		return serviceId;
	}


	public ServicesBought(@NotEmpty(message = "Service cannot be empty") Services services,
			@NotEmpty(message = "Plan cannot be empty") Plans plans,
			@NotEmpty(message = "Package cannot be empty") Packages packages,
			@NotNull(message = "Date Of Birth can not be left blank") LocalDate dateOfActivation) {
		super();
		this.services = services;
		this.plans = plans;
		this.packages = packages;
		this.dateOfActivation = dateOfActivation;
	}


	@NotEmpty(message="Service cannot be empty")
	@Column(name="serviceactivated")
	private Services services;
	
	@NotEmpty(message="Plan cannot be empty")
	@Column(name="servicetype")
	private Plans plans;
	
	@NotEmpty(message="Package cannot be empty")
	@Column(name="package")
	private Packages packages;
	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="Date Of Birth can not be left blank")
	@Column(name="doa")
	private LocalDate dateOfActivation;

	
	public ServicesBought() {
		super();
	}



	
	
	
}
