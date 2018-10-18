package com.verizon.telecom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.telecom.dao.ServicesBoughtDao;
import com.verizon.telecom.model.ServicesBought;



@Service
public class ServicesBoughtServiceImpl implements ServicesBoughtService{
	
	@Autowired
	ServicesBoughtDao servicesDao;

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
	public boolean existsByServiceId(Long serviceId) {
		return servicesDao.existsById(serviceId);
		
	}
	
	

}
