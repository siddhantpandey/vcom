package com.verizon.telecom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.telecom.dao.BillDao;
import com.verizon.telecom.model.Bill;
import com.verizon.telecom.model.Months;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	private BillDao billDao;
	
	@Override
	public List<Bill> getBillsOfParticularService(long serviceId) {
		return billDao.findAllByServiceId(serviceId);		
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

	@Override
	public List<Bill> getBillsOfParticularServiceMonthWise(Months month) {
		return billDao.findAllByMonth(month);	
	}

}
