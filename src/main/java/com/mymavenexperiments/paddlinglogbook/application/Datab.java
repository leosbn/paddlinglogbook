package com.mymavenexperiments.paddlinglogbook.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;

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
        try {
            Statement addStatement = connect.createStatement();
            addStatement.executeUpdate("insert into descents values(2, 2, '15.11.2013', 'kerry', 'caragh', 'lower')");
            //"insert into DESCENTS values (" + d.getId() + ", " + d.getAvgDifficulty() + ", " + d.getDate() + ", '" + d.getArea() + "', '" + d.getRiver() + "', '" + d.getStretch() + ");"
            addStatement.close();
        } catch (SQLException e) {
            System.out.println("Sorry, " + e);
        }
    }
}
