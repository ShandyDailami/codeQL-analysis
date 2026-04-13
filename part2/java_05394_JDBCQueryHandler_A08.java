import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_05394_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Constructor to initialize the database connection
    public java_05394_JDBCQueryHandler_A08() {
        initializeDatabase();
    }

    // Initialize database connection
    private void initializeDatabase() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database");
        } catch (Exception e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    // Method to execute a query and return the result set
    public List<String> executeQuery(String query) {
        List<String> result = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString("your_column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error in executing query: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing connections: " + e.getMessage());
            }
        }
        return result;
    }
}