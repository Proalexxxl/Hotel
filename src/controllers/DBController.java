package controllers;

import base.ConstantsDB;
import model.Client;
import model.Employee;

import java.io.File;
import java.sql.*;


public class DBController {

    ConstantsDB constantsDB;
    Client clientModel;
    Employee employeeModel;
    DBController dbController;
    String dbDriver;
    String dbName;
    String dbBaseUrl;

    public DBController(ConstantsDB constantsDB, Client clientModel, Employee employeeModel) {
        this.constantsDB = constantsDB;
        this.clientModel = clientModel;
        this.employeeModel = employeeModel;
    }

    public Connection connect() {
        dbDriver = constantsDB.DB_DRIVER;
        dbBaseUrl = constantsDB.DB_BASE_URL;
        dbName = constantsDB.DB_NAME;
        String url = dbDriver + dbBaseUrl + dbName;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public boolean isBaseExist() {
        String filePath = constantsDB.DB_BASE_URL + constantsDB.DB_NAME;
        File dbFile = new File(filePath);
        return dbFile.exists();
    }

    public void createDatabase(String fileName) {
        dbDriver = constantsDB.DB_DRIVER;
        dbBaseUrl = constantsDB.DB_BASE_URL;
        String url = dbDriver + dbBaseUrl +fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Драйвер - " + meta.getDriverName());
                System.out.println("База создана.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertGuest(String name, int quantity, int numberStars) {
        String sql = "INSERT INTO guest(name, quantity, stars) VALUES(?,?,?)";

        try (PreparedStatement pstmt = connect().prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setInt(2, quantity);
            pstmt.setInt(3, numberStars);
            pstmt.executeUpdate();
            System.out.println("Внесен клиент: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
