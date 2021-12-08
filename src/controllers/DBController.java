package controllers;

import base.ConstantsDB;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBController {

    static ConstantsDB constantsDB;

    public DBController(ConstantsDB constantsDB) {
        DBController.constantsDB = constantsDB;
    }

    public static boolean isBaseExist() {
        String filePath = ConstantsDB.DB_BASE_URL + ConstantsDB.DB_NAME;
        File dbFile = new File(filePath);
        return dbFile.exists();
    }

    public static void createDatabase(String fileName) {
        String dbDriver = constantsDB.DB_DRIVER;
        String dbBaseUrl = constantsDB.DB_BASE_URL;
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
