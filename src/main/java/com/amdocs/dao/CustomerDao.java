package com.amdocs.dao;

import com.amdocs.dao.impl.CustomerDaoImpl;

import com.amdocs.interfaces.CustomerInterface;


public class CustomerDao implements CustomerInterface{
	
	
	CustomerInterface  customerDao = new CustomerDaoImpl();
	
    
	
	
	@Override
	public void registerCustomer(String name,String email) {
		customerDao.registerCustomer(name, email);	
		
	}
	
	@Override
    public void modifyCustomerDetails(int customerid, String name,String email) {
		customerDao.modifyCustomerDetails(customerid, name, email);
	}
	
	@Override
    public void deleteCustomerRecord(int customerid) {	
		customerDao.deleteCustomerRecord(customerid);
	}
	
	@Override
    public void viewSingleCustomerRecord(int customerid) {	
		customerDao.viewSingleCustomerRecord(customerid);
		
	}
	
	@Override
    public void viewAllCustomerRecords() {
		customerDao.viewAllCustomerRecords();
	}

	
}
