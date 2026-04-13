import java.sql.*;

public class java_41503_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "username";
    private static final String PASS = "password";

    private Connection conn = null;

    public java_41503_JDBCQueryHandler_A07() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database connection: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
        return rs;
    }

    public int executeUpdate(String query) {
        Statement stmt = null;
        int rowsUpdated = 0;
        try {
            stmt = conn.createStatement();
            rowsUpdated = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute update: " + e.getMessage());
        }
        return rowsUpdated;
    }

    public static void main(String[] args) {
        // Example of executing a query to authenticate a user
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet rs = handler.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

        if (rs != null) {
            try {
                if (rs.next()) {
                    System.out.println("User authenticated successfully.");
                } else {
                    System.out.println("Invalid username or password.");
                }
            } finally {
                rs.close();
                handler.closeConnection();
            }
        }
    }
}