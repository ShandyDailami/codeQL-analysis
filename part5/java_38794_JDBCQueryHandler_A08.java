import java.sql.*;

public class java_38794_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection conn = null;

    static {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute query.");
            e.printStackTrace();
        }
        return rs;
    }

    public static void executeUpdate(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute update.");
            e.printStackTrace();
        }
    }
}