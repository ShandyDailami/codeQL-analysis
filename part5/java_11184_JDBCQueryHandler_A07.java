import java.sql.*;

public class java_11184_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        try {
            // Step 1: Initialize a connection to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Step 2: Initialize a statement object
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE role='admin'");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Email: " + email);
            }

            // Step 5: Close the ResultSet and Statement
            resultSet.close();
            statement.close();

            // Step 6: Close the Connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}