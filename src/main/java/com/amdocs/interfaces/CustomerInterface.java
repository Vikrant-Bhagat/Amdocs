package com.amdocs.interfaces;

public interface CustomerInterface {
	// Customer specific operations
    void registerCustomer(String name,String email);
    void modifyCustomerDetails(int customerid, String name,String email);
    void deleteCustomerRecord(int customerid);
    void viewSingleCustomerRecord(int customerid);
    void viewAllCustomerRecords();
}
