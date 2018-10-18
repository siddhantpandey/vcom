package com.vcom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcom.model.Customer;
import com.vcom.model.ServicesBought;

@Repository
public interface ServicesDao extends JpaRepository<ServicesBought, Long> {
	
	boolean existsByCustomerMobileNumber(String customerMobileNumber);

	boolean existsByEmailId(String emailId);

	Customer findByCustomerCustomerMobileNumber(String mobileNumber);

	Customer findByServiceId(long serviceId);

	List<Customer> findAllByLastName(String lastName);

}
