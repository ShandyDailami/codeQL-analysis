import java.sql.*;

public class java_03129_JDBCQueryHandler_A03 {
    // Define the database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection conn = null;
    private Statement stmt = null;

    // Constructor to initialize database connection
    public java_03129_JDBCQueryHandler_A03() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a query
    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Method to execute a non-query
    public int executeUpdate(String query) {
        int rowsUpdated = 0;
        try {
            rowsUpdated = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}