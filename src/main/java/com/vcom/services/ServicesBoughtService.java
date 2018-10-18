package com.vcom.services;

import java.util.List;

import com.vcom.model.Customer;
import com.vcom.model.ServicesBought;

public interface ServicesBoughtService {
	
	ServicesBought getServicesBoughtById(long servicesboughtId);
	List<ServicesBought> getAllServicesBoughts();
	ServicesBought addServicesBought(ServicesBought servicesbought);
	ServicesBought updateServicesBought(ServicesBought servicesbought);

	boolean deleteServicesBought(long servicesboughtId);
	
	
	boolean existsByCustomerMobileNumber(String customerMobileNumber);

	boolean existsByEmailId(String emailId);

	Customer findByCustomerCustomerMobileNumber(String mobileNumber);

	Customer findByServiceId(long serviceId);

	List<Customer> findAllByLastName(String lastName);

}
