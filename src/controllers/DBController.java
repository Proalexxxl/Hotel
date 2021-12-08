package controllers;

import base.ConstantsDB;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBController {

    ConstantsDB constantsDB;
    DBController dbController;
    String dbDriver;
    String dbName;
    String dbBaseUrl;

    public DBController(ConstantsDB constantsDB) {
        this.constantsDB = constantsDB;
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
}
