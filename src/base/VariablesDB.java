package base;

public class VariablesDB {

    public final static String DB_DRIVER = "jdbc:sqlite:";
    public final static String DB_BASE_URL = "G:\\\\Hillel\\Hillel_Java_elementary\\projects\\Hotel\\db\\";
    public final static String DB_NAME = "HotelDB.db";
    public static String Table_Name;

    public static String getTable_Name() {
        return Table_Name;
    }

    public static void setTable_Name(String table_Name) {
        Table_Name = table_Name;
    }
}
