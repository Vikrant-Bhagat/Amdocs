package com.amdocs.interfaces;

public interface AdvocateInterface {

    // Advocate specific operations
    void bookAppointment(int advocateId, String advocateName, int advocateFees, String appointmentDetails);
    void modifyAppointmentDetails(int appointmentId, String updatedDetails);
    void deleteAppointment(int appointmentId);
    void viewSingleAppointment(int appointmentId);
    void viewAllAppointments();
}
