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
 * @author ASD
 */
public class FArr {

    String dbName = "maindb";
    String url = "jdbc:mysql://localhost/" + dbName;
    String user = "root";
    String password = "";

    public ArrayList<String> getDoctorAvailable(String searchDate, String doctorName, String day) {
    ArrayList<String> workingHours = new ArrayList<>();
    ArrayList<String> appointments = new ArrayList<>();
    ArrayList<String> PDates = new ArrayList<>();

    String dbName = "maindb";
    String url = "jdbc:mysql://localhost/" + dbName;
    String user = "root";
    String password = "";

    try {
        Connection connection = DriverManager.getConnection(url, user, password);

        String query = "SELECT Time FROM dates "
                + "WHERE DoID IN (SELECT DoID FROM doctor WHERE DoName = ?) "
                + "AND Date = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, doctorName);
        statement.setString(2, searchDate);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String time = resultSet.getString("Time");
            appointments.add(time);
        }
        

        String query2 = "SELECT DTime FROM schedule "
                + "WHERE DoID IN (SELECT DoID FROM doctor WHERE DoName = ?) "
                + "AND day = ?";
        PreparedStatement statement2 = connection.prepareStatement(query2);
        statement2.setString(1, doctorName);
        statement2.setString(2, day);
        ResultSet resultSet2 = statement2.executeQuery();
        while (resultSet2.next()) {
            String workingHour = resultSet2.getString("DTime");
            workingHours.add(workingHour);
        }
        String query3 = "SELECT Time FROM dates "
                + "WHERE PaID IN (SELECT PaID FROM patients WHERE PaPhone = ?) "
                + "AND Date = ?";
        PreparedStatement stat3=connection.prepareStatement(query3);
        stat3.setString(1, doctorName);
        stat3.setString(2, searchDate);
        ResultSet result3=stat3.executeQuery();
        while (result3.next()) {            
            String time =result3.getString("Time");
            PDates.add(time);
        }
        stat3.close();
        result3.close();
        resultSet2.close();
        statement2.close();
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    workingHours.removeAll(PDates);
    workingHours.removeAll(appointments);
    return workingHours;

    }
}
