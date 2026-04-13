import java.sql.*;
import java.util.Properties;

public class java_10171_JDBCQueryHandler_A03 {
    // Define database connection properties
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the database driver
            Class.forName(DB_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "'");

            // Process the result set
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }

            // Close the connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}