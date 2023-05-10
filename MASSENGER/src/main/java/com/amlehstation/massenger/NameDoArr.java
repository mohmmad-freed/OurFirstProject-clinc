/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.desktop.ScreenSleepEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.AttributeList;

/**
 *
 * @author ASD
 */
public class NameDoArr {
       public ArrayList<String> getDoctorNames() {
      ArrayList<String> a=new ArrayList<>();
      
      try {
         // تحديد اسم قاعدة البيانات ومعلومات الاتصال
         String dbName = "maindb";
         String url = "jdbc:mysql://localhost/" + dbName;
         String user = "root";
         String password = "";
         
         // إنشاء اتصال بقاعدة البيانات
         Connection conn = DriverManager.getConnection(url, user, password);
         
         // إنشاء عبارة SQL لاسترداد بيانات DoName و DoPhone و DoEmail
         String query = "SELECT DoName FROM doctor";
         
         // إنشاء عبارة Statement وتنفيذ الاستعلام
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         while(rs.next()){
             String N=rs.getString("DoName");
             a.add(N);
         }
         
         

         rs.close();
         stmt.close();
         conn.close();
         
      } catch (SQLException ex) {
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
      }
      return a;

   }
    
    
}
