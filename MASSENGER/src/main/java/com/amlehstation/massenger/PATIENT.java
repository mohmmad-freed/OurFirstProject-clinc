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
import java.util.ArrayList;

/**
 *
 * @author msamalq
 */
public class PATIENT extends PERSON {

    DATE date;
    private String dbName;
    private String url;
    private String user;
    private String password;

    public PATIENT(String dbName, String url, String user, String password) {
        this.dbName = dbName;
        this.url = url;
        this.user = user;
        this.password = password;
    }
    

    public boolean addAppointment(String patientName, String doctorName, String secretaryName, String Date, String time) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url +dbName, user, password);

            String query = "INSERT INTO dates (Date, Time, PaID, DoID, SeID) "
                    + "VALUES (?, ?, (SELECT PaID FROM patients WHERE PaName = ?), "
                    + "(SELECT DoID FROM doctor WHERE DoName = ?), "
                    + "(SELECT SeID FROM secrtary WHERE SeName = ?))";
            statement = connection.prepareStatement(query);
            statement.setString(1, Date);
            statement.setString(2, time);
            statement.setString(3, patientName);
            statement.setString(4, doctorName);
            statement.setString(5, secretaryName);

            statement.executeUpdate();

            System.out.println("Appointment added successfully!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
                        return false;

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                                        return true;

            } catch (SQLException e) {
                e.printStackTrace();
                                        return false;

            }
        }
    }

    public boolean addPatient(String patientName, String patientPhone) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url +dbName, user, password);

            String query = "INSERT INTO patients (PaName, PaPhone) VALUES (?, ?)";

            statement = connection.prepareStatement(query);

            statement.setString(1, patientName);
            statement.setString(2, patientPhone);

            statement.executeUpdate();

            System.out.println("Patient added successfully");
                        return true;

        } catch (SQLException e) {
            e.printStackTrace();
                        return false;

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    
                }
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                            return false;

            }
        }
    }
public boolean deleteAppointment(String time, String date, String paName, String doName) {
    Connection connection = null;
    PreparedStatement statement = null;
    boolean success = false;

    try {
        connection = DriverManager.getConnection(url + dbName, user, password);

        String query = "DELETE FROM dates WHERE Time = ? AND Date = ? AND PaID = (SELECT PaID FROM patients WHERE PaName = ?) AND DoID = (SELECT DoID FROM doctor WHERE DoName = ?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, time);
        statement.setString(2, date);
        statement.setString(3, paName);
        statement.setString(4, doName);
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

    return success;
}


}
