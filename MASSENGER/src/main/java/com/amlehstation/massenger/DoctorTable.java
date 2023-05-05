/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

/**
 *
 * @author ASD
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class DoctorTable {
   public DefaultTableModel getTableModel() {
      DefaultTableModel model = null;
      
      try {
         // تحديد اسم قاعدة البيانات ومعلومات الاتصال
         String dbName = "maindb";
         String url = "jdbc:mysql://localhost/" + dbName;
         String user = "root";
         String password = "";
         
         // إنشاء اتصال بقاعدة البيانات
         Connection conn = DriverManager.getConnection(url, user, password);
         
         // إنشاء عبارة SQL لاسترداد بيانات DoName و DoPhone و DoEmail
         String query = "SELECT DoName, DoPhone, DoEmail FROM doctor";
         
         // إنشاء عبارة Statement وتنفيذ الاستعلام
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         
         // إنشاء DefaultTableModel لعرض النتائج
         model = new DefaultTableModel(new String[]{"DoName", "DoPhone", "DoEmail"}, 0);
         
         // استرداد البيانات وإضافتها إلى DefaultTableModel
         while (rs.next()) {
            String doName = rs.getString("DoName");
            String doPhone = rs.getString("DoPhone");
            String doEmail = rs.getString("DoEmail");
            model.addRow(new Object[]{doName, doPhone, doEmail});
         }
         
         // إغلاق الاتصال والنتائج
         rs.close();
         stmt.close();
         conn.close();
         
      } catch (SQLException ex) {
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
      }
      
      return model;
   }
}

