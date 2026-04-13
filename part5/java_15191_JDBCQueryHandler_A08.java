import java.sql.*;

public class java_15191_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE name = 'test'");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String passwordHash = resultSet.getString("password");
                // In a real-world application, you would not store passwords in plain text.
                // Instead, you would store hashed versions of the passwords.
                // Use a library like BCrypt or a service like Spring Security for this purpose.

                System.out.println("Name: " + name);
                System.out.println("Password Hash: " + passwordHash);
            }

            // Step 5: Clean Up (Close the ResultSet and Statement)
            resultSet.close();
            statement.close();

            // Step 6: Close the Connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}