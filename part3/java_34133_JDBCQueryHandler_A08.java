import java.sql.*;

public class java_34133_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a SQL statement
            String insertUser = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUser);

            // Set the parameters
            preparedStatement.setString(1, "newUser");
            preparedStatement.setString(2, "password");

            // Step 3: Execute the SQL statement
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("User inserted successfully.");
            } else {
                System.out.println("No rows inserted.");
            }

            // Step 4: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}