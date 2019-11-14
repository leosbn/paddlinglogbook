package com.mymavenexperiments.paddlinglogbook.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Date;

public class Datab {

    private Connection connect;
    private final String host = "jdbc:derby://localhost:1527/paddlelogbook1";
    //db has no user or pwd, just connection

    public Datab() {
        this.connect = null;
    }
    
    public void connect(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection(host);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToTable(Descent d) {
        Date convertedDate = Date.valueOf(d.getDate());
        String statementIHopeWorks = "insert into DESCENTS values(" + d.getAvgDifficulty() + ", '" + convertedDate + "', '" + d.getArea() + "', '" + d.getRiver() + "', '" + d.getStretch() + "')";
        try {
            PreparedStatement addStatement = connect.prepareStatement(statementIHopeWorks);
            addStatement.executeUpdate();
            addStatement.close();
        } catch (SQLException e) {
            System.out.println("Sorry, " + e);
        }
    }
}
