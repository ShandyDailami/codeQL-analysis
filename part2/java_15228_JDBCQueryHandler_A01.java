import java.sql.*;
import java.util.Properties;

public class java_15228_JDBCQueryHandler_A01 {
    private static Connection connection = null;
    private static Statement stmt = null;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Constructor to initialize connection
    public java_15228_JDBCQueryHandler_A01() {
        initializeConnection();
    }

    // Method to initialize connection
    private void initializeConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to execute read-only query
    public ResultSet executeReadOnlyQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to execute write-only query
    public int executeWriteOnlyQuery(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}