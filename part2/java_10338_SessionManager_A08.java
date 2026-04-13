import java.sql.*;

public class java_10338_SessionManager_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    // Open a connection to the database
    private Connection conn;

    public java_10338_SessionManager_A08() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }

    // Method to execute a non-security sensitive query
    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query");
            e.printStackTrace();
        }
    }

    // Method to execute a security sensitive query involving integrity failure
    public void executeIntegrityFailureQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.out.println("You can edit this record, but not delete it!");
            }
        } catch (SQLException e) {
            System.out.println("Error executing query");
            e.printStackTrace();
        }
    }

    // Method to close the connection to the database
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.executeQuery("SELECT * FROM Users");
        manager.executeIntegrityFailureQuery("SELECT * FROM Users WHERE id = 1");
        manager.closeConnection();
    }
}