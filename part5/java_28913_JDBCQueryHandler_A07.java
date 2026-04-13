import java.sql.*;

public class java_28913_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String username = "admin"; // This should be fetched from the user input
        String dbUrl = "jdbc:mysql://localhost:3306/mydb"; // Database URL
        String dbUsername = "root"; // Database Username
        String dbPassword = "password"; // Database Password

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection to the database
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // Step 3: Prepare a statement
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            // Step 4: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                // Step 5: Process the result
                String passwordHash = resultSet.getString("PasswordHash");
                System.out.println("PasswordHash: " + passwordHash);
            } else {
                System.out.println("No user found with the username: " + username);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}