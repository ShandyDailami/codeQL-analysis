import java.sql.*;

public class java_33850_JDBCQueryHandler_A08 {
    private Connection conn;

    // Constructor
    public java_33850_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to perform SQL queries
    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return null;
        }
    }

    // Method to perform SQL updates and deletes
    public int executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            int affectedRows = stmt.executeUpdate(query);
            return affectedRows;
        } catch (SQLException e) {
            System.out.println("Error executing update: " + e.getMessage());
            return -1;
        }
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}