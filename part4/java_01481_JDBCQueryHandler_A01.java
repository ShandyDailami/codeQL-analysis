import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01481_JDBCQueryHandler_A01 {

    // The URL, username, and password are used for connecting to the database
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Execute a query
            conn.createStatement().execute("SELECT * FROM mytable");

            // Close the connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}