package com.verizon.telecom.services;

import com.verizon.telecom.model.ServicesBought;

public interface ServicesBoughtService {

	boolean existsByServiceId(Long serviceId);

	ServicesBought addServicesBought(ServicesBought servicesbought);

	ServicesBought updateServicesBought(ServicesBought servicesbought);

	boolean deleteServicesBought(long servicesboughtId);

	ServicesBought getServicesBoughtById(long servicesboughtId);

}
