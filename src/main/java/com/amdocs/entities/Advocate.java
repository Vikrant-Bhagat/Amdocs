package com.amdocs.entities;

public class Advocate {
	private int advocateId;
	private String advocate_name;
	private int advocate_fees;
	private String appointmentDetails;
	private int appointmentId;
   

    public Advocate(int advocateId,String advocate_name,int advocate_fees,String appointmentDetails,int appointmentId) {
        this.advocateId = advocateId;
        this.advocate_name = advocate_name;
        this.advocate_fees = advocate_fees;
        this.appointmentDetails = appointmentDetails;
        this.appointmentId = appointmentId;
        
    }

    public int getAdvocateId() {
        return advocateId;
    }
    public String getadvocate_name() {
    	return advocate_name;
    }
    public int getadvocate_fees() {
        return advocate_fees;
    }
    public String getappointmentDetails() {
    	return appointmentDetails;
    }
    public int getappointmentid() {
    	return appointmentId;
    }
    public void setAdvocateId(int  advocateId) {
    	this.advocateId = advocateId;
    }
    public void setAdvocate_name(String advocate_name) {
    	this.advocate_name = advocate_name;
    }
    public void setAdvocate_fees(int advocate_fees) {
    	this.advocate_fees = advocate_fees;
    }
    public void setAppointmentDetails(String appointmentDetails) {
    	this.appointmentDetails = appointmentDetails;
    }
    
}
