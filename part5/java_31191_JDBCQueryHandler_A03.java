import java.sql.*;

public class java_31191_JDBCQueryHandler_A03 {

    // Database credentials
    private String url = "jdbc:mysql://localhost:3306/dbname";
    private String username = "username";
    private String password = "password";

    // Initialize connection
    private Connection conn = null;
    private Statement stmt = null;

    // Constructor
    public java_31191_JDBCQueryHandler_A03() {
        initializeConnection();
    }

    // Initialize connection method
    private void initializeConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute query
    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to update a database
    public int executeUpdate(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Method to close connection
    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}