package com.verizon.telecom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.telecom.dao.BillDao;
import com.verizon.telecom.model.Bill;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	private BillDao billDao;
	
	@Override
	public List<Bill> getBillsOfParticularService(long customerId, long serviceId) {
		//return billDao.findAllByCustomerAndServiceId(customerId, serviceId);
		return null;
	}

	@Override
	public List<Bill> getAllBills(long customerId) {
		return billDao.findAllByCustomerId(customerId);
	}

	@Override
	public Bill payBill(Bill bill) {
		return billDao.save(bill);
	}

	@Override
	public boolean existsByBillId(long billId) {
		return billDao.existsByBillId(billId);
	}

}
