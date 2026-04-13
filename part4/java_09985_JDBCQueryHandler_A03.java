import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_09985_JDBCQueryHandler_A03 {
    // URL, username, and password for the database
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "myusername";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        // Ensure we're using a JDBC driver that supports MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
            return;
        }

        // Establish a connection pool
        DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        // Use the connection pool to get a connection
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        // Prepare a SQL query
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set the parameter value
        statement.setString(1, "exampleuser");

        // Execute the query
        ResultSet result = statement.executeQuery();

        // Process the result
        while (result.next()) {
            String username = result.getString("username");
            String password = result.getString("password");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        // Close the connection
        connection.close();
    }
}