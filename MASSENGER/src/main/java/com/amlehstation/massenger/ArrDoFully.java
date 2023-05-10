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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASD
 */
public class ArrDoFully {
           public ArrayList<String> getDoctorFully(String searchDate1,String doctorName1) {
      ArrayList<String> a=new ArrayList<>();
      

        // تعيين معلومات الاتصال بقاعدة البيانات
        String dbName = "maindb";
         String url = "jdbc:mysql://localhost/" + dbName;
         String user = "root";
         String password = "";




        // قائمة لتخزين المواعيد
        ArrayList<String> appointments = new ArrayList<>();

        try {
            // إنشاء اتصال بقاعدة البيانات
            Connection connection = DriverManager.getConnection(url, user, password);

            // إعداد الاستعلام للحصول على المواعيد الخاصة بالدكتور
            String query = "SELECT Time FROM dates " +
                           "WHERE DoID IN (SELECT DoID FROM doctor WHERE DoName = ?) " +
                           "AND Date = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, doctorName1);
            statement.setString(2, searchDate1);

            // تنفيذ الاستعلام واسترجاع النتائج
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
                String time = resultSet.getString("Time");
                String appointment =  time;
                appointments.add(appointment);
            }

            // إغلاق الاتصال بقاعدة البيانات
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

return appointments;
    

           }}

