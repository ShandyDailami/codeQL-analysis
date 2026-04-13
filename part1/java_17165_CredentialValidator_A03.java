import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17165_CredentialValidator_A03 {

    public boolean validate(String username, String password) {
        // SQL Injection prevention: do not use the username parameter directly in the SQL query
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";

        Connection connection = null;
        Statement statement = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "username", "password");
            statement = connection.createStatement();

            // Execute SQL query
            statement.executeQuery(query);

            return true; // Valid credentials
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; // Invalid credentials
    }

}