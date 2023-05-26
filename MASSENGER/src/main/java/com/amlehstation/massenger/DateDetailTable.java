/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


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
            String sql = "SELECT dates.Time,dates.Date,secrtary.SeName,doctor.DoName,patients.PaName "
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
            model.setColumnIdentifiers(new String[]{"Time", "Date", "Secretary", "Doctor", "Patients"});

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
    
  public DefaultTableModel getTableModelByName(String name) {
    DefaultTableModel model = null;
    try {
        Connection conn = DriverManager.getConnection(dbURL, username, password);
        name += "%";
        String sql = "SELECT dates.Time,dates.Date,secrtary.SeName,doctor.DoName,patients.PaName "
                + "FROM ((dates "
                + "INNER JOIN patients ON dates.PaID = patients.PaID) "
                + "INNER JOIN doctor ON dates.DoID = doctor.DoID) "
                + "INNER JOIN secrtary ON dates.SeID = secrtary.SeID "
                + "WHERE patients.PaName LIKE ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);

        ResultSet rs = statement.executeQuery();

        model = new DefaultTableModel(new Object[][]{}, new String[]{"Time", "Date", "Secretary", "Doctor", "Patients"}) {
            @Override
            public void setValueAt(Object aValue, int row, int column) {}
        };

        while (rs.next()) {
            String time = rs.getString("Time");
            String date = rs.getString("Date");
            String seName = rs.getString("SeName");
            String doName = rs.getString("DoName");
            String paName = rs.getString("PaName");
            model.addRow(new Object[]{time, date, seName, doName, paName});
        }

        rs.close();
        statement.close();
        conn.close();

    } catch (SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }

   if (model != null) {
    JTable table = new JTable(model);
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
    sorter.setSortKeys(
            java.util.List.of(
                    new RowSorter.SortKey(1, SortOrder.ASCENDING), // ترتيب حسب العمود 1 (التاريخ)
                    new RowSorter.SortKey(0, SortOrder.ASCENDING) // ترتيب حسب العمود 0 (الوقت)
            )
    );
    table.setRowSorter(sorter);
    model = (DefaultTableModel) table.getModel();
}

    return model;
}

public DefaultTableModel getTableModelByPhone(String phone) {
    DefaultTableModel model = null;
    try {
        Connection conn = DriverManager.getConnection(dbURL, username, password);
        phone += "%";
        String sql = "SELECT dates.Time,dates.Date,secrtary.SeName,doctor.DoName,patients.PaName "
                + "FROM ((dates "
                + "INNER JOIN patients ON dates.PaID = patients.PaID) "
                + "INNER JOIN doctor ON dates.DoID = doctor.DoID) "
                + "INNER JOIN secrtary ON dates.SeID = secrtary.SeID "
                + "WHERE patients.PaPhone LIKE ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, phone);

        ResultSet rs = statement.executeQuery();

        model = new DefaultTableModel(new Object[][]{}, new String[]{"Time", "Date", "Secretary", "Doctor", "Patients"}) {
            @Override
            public void setValueAt(Object aValue, int row, int column) {}
        };

        while (rs.next()) {
            String time = rs.getString("Time");
            String date = rs.getString("Date");
            String seName = rs.getString("SeName");
            String doName = rs.getString("DoName");
            String paName = rs.getString("PaName");
            model.addRow(new Object[]{time, date, seName, doName, paName});
        }

        rs.close();
        statement.close();
        conn.close();

    } catch (SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }

    if (model != null) {
        JTable table = new JTable(model);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setSortKeys(
                java.util.List.of(
                        new RowSorter.SortKey(1, SortOrder.ASCENDING),
                        new RowSorter.SortKey(0, SortOrder.ASCENDING)
                )
        );
        table.setRowSorter(sorter);
        model = (DefaultTableModel) table.getModel();
    }

    return model;
}
public DefaultTableModel getTableModelByDoctorPhone(String doctorPhone) {
    DefaultTableModel model = null;
    try {
        Connection conn = DriverManager.getConnection(dbURL, username, password);
        doctorPhone += "%";
        String sql = "SELECT dates.Time, dates.Date, secrtary.SeName, doctor.DoName, patients.PaName "
                + "FROM ((dates "
                + "INNER JOIN patients ON dates.PaID = patients.PaID) "
                + "INNER JOIN doctor ON dates.DoID = doctor.DoID) "
                + "INNER JOIN secrtary ON dates.SeID = secrtary.SeID "
                + "WHERE doctor.DoPhone LIKE ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, doctorPhone);

        ResultSet rs = statement.executeQuery();

        model = new DefaultTableModel(new Object[][]{}, new String[]{"Time", "Date", "Secretary", "Doctor", "Patients"}) {
            @Override
            public void setValueAt(Object aValue, int row, int column) {}
        };

        while (rs.next()) {
            String time = rs.getString("Time");
            String date = rs.getString("Date");
            String seName = rs.getString("SeName");
            String doName = rs.getString("DoName");
            String paName = rs.getString("PaName");
            model.addRow(new Object[]{time, date, seName, doName, paName});
        }

        rs.close();
        statement.close();
        conn.close();

    } catch (SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }

    if (model != null) {
        JTable table = new JTable(model);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setSortKeys(
                java.util.List.of(
                        new RowSorter.SortKey(1, SortOrder.ASCENDING),
                        new RowSorter.SortKey(0, SortOrder.ASCENDING)
                )
        );
        table.setRowSorter(sorter);
        model = (DefaultTableModel) table.getModel();
    }

    return model;
}


    
}
