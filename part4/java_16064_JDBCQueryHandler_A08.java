import java.sql.*;

public class java_16064_JDBCQueryHandler_A08 {
    private Connection conn;

    // Constructor
    public java_16064_JDBCQueryHandler_A08(String dbURL, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, user, password);
    }

    // Method to execute a SELECT query
    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    // Method to execute an INSERT, UPDATE, DELETE query
    public int executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }

    // Method to close the connection
    public void closeConnection() throws SQLException {
        conn.close();
    }

    // Main method
    public static void main(String[] args) {
        // Provide your own database URL, user, and password
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "myuser";
        String password = "mypassword";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(dbURL, user, password);

            // Example: SELECT query
            String selectQuery = "SELECT * FROM Users";
            ResultSet result = handler.executeQuery(selectQuery);
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Example: INSERT query
            String insertQuery = "INSERT INTO Users (username, password) VALUES ('newuser', 'newpassword')";
            int rowsInserted = handler.executeUpdate(insertQuery);
            System.out.println("Rows inserted: " + rowsInserted);

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}