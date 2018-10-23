package com.verizon.telecom.services;

import java.util.List;

import com.verizon.telecom.model.Customer;
import com.verizon.telecom.model.ServicesBought;

public interface ServicesBoughtService {

	boolean existsByServiceId(Long serviceId);

	ServicesBought addServicesBought(ServicesBought servicesbought);

	ServicesBought updateServicesBought(ServicesBought servicesbought);

	boolean deleteServicesBought(long servicesboughtId);

	ServicesBought getServicesBoughtById(long servicesboughtId);

	List<ServicesBought> getAllServices();
	List<ServicesBought> getServiceByCustomer(Customer cust);

}
