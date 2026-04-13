import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29619_JDBCQueryHandler_A07 {
    // URL and credentials for the MySQL database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Main method to test the JDBCQueryHandler
    public static void main(String[] args) {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // Handle the ResultSet
            while (rs.next()) {
                // Retrieve by column name
                String username = rs.getString("username");
                String password = rs.getString("password");

                // Print out the username and password
                System.out.println("username: " + username);
                System.out.println("password: " + password);
            }

            // Close the ResultSet, Statement and Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}