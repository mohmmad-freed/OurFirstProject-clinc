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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASD
 */
public class SecretaryTable {
    public DefaultTableModel getTableModel() {
      DefaultTableModel model = null;
      try {
         String dbName = "maindb";
         String url = "jdbc:mysql://localhost/" + dbName;
         String user = "root";
         String password = "";
         
         Connection conn = DriverManager.getConnection(url, user, password);
         
         String query = "SELECT SeName, SePhone, SeEmail FROM secrtary";
         
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         
         model = new DefaultTableModel(new String[]{"Name", "Phone", "Email"}, 0);
         
         while (rs.next()) {
            String doName = rs.getString("SeName");
            String doPhone = rs.getString("SePhone");
            String doEmail = rs.getString("SeEmail");
            model.addRow(new Object[]{doName, doPhone, doEmail});
         }
         
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
public DefaultTableModel getTableModelByName(String name) {
    DefaultTableModel model = null;
    try {
        String dbName = "maindb";
        String url = "jdbc:mysql://localhost/" + dbName;
        String user = "root";
        String password = "";

        Connection conn = DriverManager.getConnection(url, user, password);

        String query = "SELECT DoName, DoPhone, DoEmail FROM doctor WHERE DoName = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, name);

        ResultSet rs = pst.executeQuery();

        model = new DefaultTableModel(new Object[][]{}, new String[]{"Name", "Phone", "Email"}) {
            @Override
            public void setValueAt(Object aValue, int row, int column) {}
        };

        while (rs.next()) {
            String doName = rs.getString("DoName");
            String doPhone = rs.getString("DoPhone");
            String doEmail = rs.getString("DoEmail");
            model.addRow(new Object[]{doName, doPhone, doEmail});
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }

    return model;
}

public DefaultTableModel getTableModelByPhone(String phone) {
    DefaultTableModel model = null;
    try {
        String dbName = "maindb";
        String url = "jdbc:mysql://localhost/" + dbName;
        String user = "root";
        String password = "";

        Connection conn = DriverManager.getConnection(url, user, password);

        String query = "SELECT DoName, DoPhone, DoEmail FROM doctor WHERE DoPhone = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, phone);

        ResultSet rs = pst.executeQuery();

        model = new DefaultTableModel(new Object[][]{}, new String[]{"Name", "Phone", "Email"}) {
            @Override
            public void setValueAt(Object aValue, int row, int column) {}
        };

        while (rs.next()) {
            String doName = rs.getString("DoName");
            String doPhone = rs.getString("DoPhone");
            String doEmail = rs.getString("DoEmail");
            model.addRow(new Object[]{doName, doPhone, doEmail});
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }

    return model;
}

    
}
