package com.vcom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcom.dao.ServicesDao;
import com.vcom.model.Customer;
import com.vcom.model.ServicesBought;

@Service
public class ServicesBoughtServiceImpl implements ServicesBoughtService{
	
	@Autowired
	ServicesDao servicesDao;

	@Override
	public ServicesBought getServicesBoughtById(long servicesboughtId) {
		ServicesBought serviceBought = null;
		
		Optional<ServicesBought> optServ = servicesDao.findById(servicesboughtId);
		if(optServ.isPresent()) {
			serviceBought = optServ.get();
		}
		return serviceBought;
		
	}

	@Override
	public List<ServicesBought> getAllServicesBoughts() {
		return servicesDao.findAll();
	}

	@Override
	public ServicesBought addServicesBought(ServicesBought servicesbought) {
		return servicesDao.save(servicesbought);
	}

	@Override
	public ServicesBought updateServicesBought(ServicesBought servicesbought) {
		return servicesDao.save(servicesbought);
	}

	@Override
	public boolean deleteServicesBought(long servicesboughtId) {
		boolean isDeleted = false;
		
		if(servicesDao.existsById(servicesboughtId)) {
			servicesDao.deleteById(servicesboughtId);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public boolean existsByCustomerMobileNumber(String customerMobileNumber) {
		return servicesDao.existsByCustomerMobileNumber(customerMobileNumber);
	}

	@Override
	public boolean existsByEmailId(String emailId) {
		return servicesDao.existsByEmailId(emailId);
	}

	@Override
	public Customer findByCustomerCustomerMobileNumber(String mobileNumber) {
		return servicesDao.findByCustomerCustomerMobileNumber(mobileNumber);
	}

	@Override
	public Customer findByServiceId(long serviceId) {
		return servicesDao.findByServiceId(serviceId);
	}

	@Override
	public List<Customer> findAllByLastName(String lastName) {
		return servicesDao.findAllByLastName(lastName);
	}
	
	

}
