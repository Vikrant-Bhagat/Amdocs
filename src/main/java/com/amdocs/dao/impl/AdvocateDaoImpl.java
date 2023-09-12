package com.amdocs.dao.impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amdocs.interfaces.AdvocateInterface;

public class AdvocateDaoImpl implements AdvocateInterface {

    private final String jdbcUrl = "jdbc:mysql://localhost:3306/my_database";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Vv@12347890";

    // JDBC Connection
    private Connection connection;

    public AdvocateDaoImpl() {
        try {
            // Initialize the JDBC driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    @Override
    public void bookAppointment(int advocateId, String advocateName, int advocateFees, String appointmentDetails) {
        try {
            String sql = "INSERT INTO advocate (advocateId, advocate_name, advocate_fees, appointmentDetails) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, advocateId);
            preparedStatement.setString(2, advocateName);
            preparedStatement.setInt(3, advocateFees);
            preparedStatement.setString(4, appointmentDetails);
            
            preparedStatement.executeUpdate();
            System.out.println("Appointment booked successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyAppointmentDetails(int appointmentId, String updatedDetails) {
        try {
            String sql = "UPDATE advocate SET appointmentDetails = ? WHERE appointmentId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedDetails);
            preparedStatement.setInt(2, appointmentId);
            preparedStatement.executeUpdate();
            System.out.println("Appointment details modified successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteAppointment(int appointmentId) {
        try {
            String sql = "DELETE FROM advocate WHERE appointmentId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, appointmentId);
            preparedStatement.executeUpdate();
            System.out.println("Appointment deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewSingleAppointment(int appointmentId) {
        try {
            String sql = "SELECT * FROM advocate WHERE appointmentId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, appointmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int advocateId = resultSet.getInt("advocateId");
                String advocateName = resultSet.getString("advocate_name");
                int advocateFees = resultSet.getInt("advocate_fees");
                String appointmentDetails = resultSet.getString("appointmentDetails");
                System.out.println("Appointment ID: " + appointmentId + ", Advocate ID: " + advocateId + ", Advocate Name: " + advocateName + ", Advocate Fees: " + advocateFees + ", Appointment Details: " + appointmentDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void viewAllAppointments() {
        try {
            String sql = "SELECT * FROM advocate";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int appointmentId = resultSet.getInt("appointmentId");
                int advocateId = resultSet.getInt("advocateId");
                String advocateName = resultSet.getString("advocate_name");
                int advocateFees = resultSet.getInt("advocate_fees");
                String appointmentDetails = resultSet.getString("appointmentDetails");
                System.out.println("Appointment ID: " + appointmentId + ", Advocate ID: " + advocateId + ", Advocate Name: " + advocateName + ", Advocate Fees: " + advocateFees + ", Appointment Details: " + appointmentDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

