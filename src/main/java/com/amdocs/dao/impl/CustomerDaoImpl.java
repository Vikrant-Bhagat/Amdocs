package com.amdocs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amdocs.interfaces.CustomerInterface;

public class CustomerDaoImpl implements CustomerInterface {

    private final String jdbcUrl = "jdbc:mysql://localhost:3306/my_database";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Vv@12347890";

    // JDBC Connection
    private Connection connection;

    public CustomerDaoImpl() {
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
    public void registerCustomer(String name, String email) {
        try {
            String sql = "INSERT INTO customer (name, email) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyCustomerDetails(int customerid, String name, String email) {
        try {
            String sql = "UPDATE customer SET name = ?, email = ? WHERE customerid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, customerid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomerRecord(int customerid) {
        try {
            String sql = "DELETE FROM customer WHERE customerid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewSingleCustomerRecord(int customerid) {
        try {
            String sql = "SELECT * FROM customer WHERE customerid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,customerid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customerid");
                String customerName = resultSet.getString("name");
                String customerEmail = resultSet.getString("email");
                System.out.println("Customer ID: " + customerId + ", Name: " + customerName + ", Email: " + customerEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewAllCustomerRecords() {
        try {
            String sql = "SELECT * FROM customer";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerid = resultSet.getInt("customerid");
                String customerName = resultSet.getString("name");
                String customerEmail = resultSet.getString("email");
                System.out.println("Customer ID: " + customerid + ", Name: " + customerName + ", Email: " + customerEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
