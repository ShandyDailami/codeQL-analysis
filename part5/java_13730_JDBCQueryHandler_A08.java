import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13730_JDBCQueryHandler_A08 {
    // Define the database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // Define the database username and password
    private static final String USER = "root";
    private static final String PASS = "password";

    // Open a connection to the database
    private Connection conn;

    // Initialize the connection
    public java_13730_JDBCQueryHandler_A08() {
        openConnection();
    }

    // Open a connection to the database
    private void openConnection() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the connection
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a query and return the result
    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Main method for testing
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet rs = handler.executeQuery("SELECT * FROM Users");
        try {
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            handler.closeConnection();
        }
    }
}