import java.sql.*;

public class java_34094_JDBCQueryHandler_A03 {
    // Create a connection
    private Connection conn = null;

    // Database credentials
    private final String DB_USERNAME = "username";
    private final String DB_PASSWORD = "password";
    private final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Establish a connection
    public java_34094_JDBCQueryHandler_A03() {
        establishConnection();
    }

    // Method to establish a connection to the database
    private void establishConnection() {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a SELECT query
    public void selectQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a INSERT query
    public void insertQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a DELETE query
    public void deleteQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a UPDATE query
    public void updateQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();
        queryHandler.selectQuery("SELECT * FROM Users");
        queryHandler.closeConnection();
    }
}