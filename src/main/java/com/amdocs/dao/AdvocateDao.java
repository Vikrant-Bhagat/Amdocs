package com.amdocs.dao;

import com.amdocs.dao.impl.AdvocateDaoImpl;


import com.amdocs.interfaces.AdvocateInterface;
public class AdvocateDao implements AdvocateInterface {

    AdvocateInterface advocateDao = new AdvocateDaoImpl();
 
        
    @Override
    public void bookAppointment(int advocateId, String advocateName, int advocateFees, String appointmentDetails) {
        
    	advocateDao.bookAppointment(advocateId,advocateName,advocateFees,appointmentDetails);
        
    }

    @Override
    public void modifyAppointmentDetails(int appointmentId, String updatedDetails) {
        advocateDao.modifyAppointmentDetails(appointmentId, updatedDetails);
    }

    @Override
    public void deleteAppointment(int appointmentId) {
        advocateDao.deleteAppointment(appointmentId);
    }

    @Override
    public void viewSingleAppointment(int appointmentId) {
        advocateDao.viewSingleAppointment(appointmentId);
    }

    @Override
    public void viewAllAppointments() {
        advocateDao.viewAllAppointments();
    }

    
    
}

