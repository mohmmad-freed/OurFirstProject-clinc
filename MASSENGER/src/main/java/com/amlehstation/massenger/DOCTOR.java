/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author msamalq
 */
public class DOCTOR extends PERSON {

    private DSCHEDULE s;

    public DOCTOR() {
    }
    

    private String dbName;
    private String url;
    private String user;
    private String password;

    public DOCTOR(String dbName, String url, String user, String password) {
        this.dbName = dbName;
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
       public boolean deleteDoctors(String name) {
        boolean success = false;

        if (deleteDoctorDates(name) && deleteDoctorSchedules(name) && deleteDoctor(name)) {
            success = true;
        }
                System.out.println("all");


        return success;
    }

    private boolean deleteDoctor(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean success = false;

        try {
            connection = DriverManager.getConnection(url + dbName, user, password);

            String query = "DELETE FROM doctor WHERE DoName = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            int rowsAffected = statement.executeUpdate();

            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

                System.out.println("doc");

        return success;
    }

   private boolean deleteDoctorSchedules(String name) {
    Connection connection = null;
    PreparedStatement statement = null;
    boolean success = false;

    try {
        connection = DriverManager.getConnection(url + dbName, user, password);

        // Check if the doctor has schedules
        String checkQuery = "SELECT COUNT(*) FROM schedule WHERE DoID = (SELECT DoID FROM doctor WHERE DoName = ?)";
        statement = connection.prepareStatement(checkQuery);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);

        if (count == 0) {
            // No schedules for the doctor
            success = true;
        } else {
            // Delete the doctor's schedules
            String deleteQuery = "DELETE FROM schedule WHERE DoID = (SELECT DoID FROM doctor WHERE DoName = ?)";
            statement = connection.prepareStatement(deleteQuery);
            statement.setString(1, name);
            int rowsAffected = statement.executeUpdate();

            success = rowsAffected > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    System.out.println("schedule");

    return success;
}
   private boolean deleteDoctorDates(String name) {
    Connection connection = null;
    PreparedStatement statement = null;
    boolean success = false;

    try {
        connection = DriverManager.getConnection(url + dbName, user, password);

        // Check if there are dates for the doctor
        String checkQuery = "SELECT COUNT(*) FROM dates WHERE DoID = (SELECT DoID FROM doctor WHERE DoName = ?)";
        statement = connection.prepareStatement(checkQuery);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);

        if (count == 0) {
            success = true;
        } else {
            // Delete the doctor's dates
            String deleteQuery = "DELETE FROM dates WHERE DoID = (SELECT DoID FROM doctor WHERE DoName = ?)";
            statement = connection.prepareStatement(deleteQuery);
            statement.setString(1, name);
            int rowsAffected = statement.executeUpdate();

            success = rowsAffected > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    System.out.println("date");

    return success;
}

   }
