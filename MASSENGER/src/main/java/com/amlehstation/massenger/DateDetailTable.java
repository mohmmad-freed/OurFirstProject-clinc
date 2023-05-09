/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

import java.sql.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASD
 */
public class DateDetailTable {
    private String dbURL;
    private String username;
    private String password;

    public DateDetailTable(String dbURL, String username, String password) {
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }

    public DefaultTableModel getDateDetails() {
        DefaultTableModel model = new DefaultTableModel();

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            Statement stmt = conn.createStatement();

            String sql = "SELECT dates.Date, dates.Time, patients.PaName, doctor.DoName, secrtary.SeName "
                    + "FROM ((dates "
                    + "INNER JOIN patients ON dates.PaID = patients.PaID) "
                    + "INNER JOIN doctor ON dates.DoID = doctor.DoID) "
                    + "INNER JOIN secrtary ON dates.SeID = secrtary.SeID";

            ResultSet rs = stmt.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();

            int numColumns = rsmd.getColumnCount();

            for (int i = 1; i <= numColumns; i++) {
                model.addColumn(rsmd.getColumnLabel(i));
            }
            model.setColumnIdentifiers(new String[]{"Patients", "Doctor", "Date", "Time", "Secretary"});

            while (rs.next()) {
                Object[] rowData = new Object[numColumns];
                for (int i = 1; i <= numColumns; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
    
}
