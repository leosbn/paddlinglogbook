package com.mymavenexperiments.paddlinglogbook.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class Datab {

    private Connection connect;
    private final String host = "jdbc:derby://localhost:1527/paddlelogbook1";
    //db has no user or pwd, just connection

    public Datab() {
        this.connect = null;
    }

    public void connect() {
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

    public List<Descent> listAll() {
        List<Descent> listOfDescents = new ArrayList<>();
        try {
            PreparedStatement listAllStatement = connect.prepareStatement("select * from descents");
            ResultSet rs = listAllStatement.executeQuery();
            while (rs.next()) {
                listAllStatement.getGeneratedKeys();
                rs.getInt(1);
                Descent d = new Descent(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getString(3), rs.getString(4), rs.getString(5));
                listOfDescents.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfDescents;
    }

    public List<Descent> listOnlyRiver(String river) {
        List<Descent> listOfDescents = new ArrayList<>();
        String statement = "select * from descents where river = '" + river + "'";
        try {
            PreparedStatement listOnRiverStatement = connect.prepareStatement(statement);
            ResultSet rs = listOnRiverStatement.executeQuery();
            while (rs.next()) {
                listOnRiverStatement.getGeneratedKeys();
                rs.getInt(1);
                Descent d = new Descent(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getString(3), rs.getString(4), rs.getString(5));
                listOfDescents.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfDescents;
    }

    public List<Descent> listOnlyDate(LocalDate date) {
        List<Descent> listOfDescents = new ArrayList<>();
        Date d = Date.valueOf(date);
        String statement = "select * from descents where date = '" + d + "'";
        try {
            PreparedStatement listOnDateStatement = connect.prepareStatement(statement);
            ResultSet rs = listOnDateStatement.executeQuery();
            while (rs.next()) {
                listOnDateStatement.getGeneratedKeys();
                rs.getInt(1);
                Descent de = new Descent(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getString(3), rs.getString(4), rs.getString(5));
                listOfDescents.add(de);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfDescents;
    }

    public void closeProgr() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
