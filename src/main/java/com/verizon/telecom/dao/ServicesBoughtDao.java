package com.verizon.telecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.telecom.model.ServicesBought;
@Repository
public interface ServicesBoughtDao extends JpaRepository<ServicesBought, Long> {

	boolean existsByServiceId(Long serviceId);
	
}
