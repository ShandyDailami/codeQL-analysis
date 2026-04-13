import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_40150_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 2: Establish the database connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",  // replace with your database details
                    "username", // replace with your username
                    "password" // replace with your password
            );

            // Step 3: Execute SQL queries
            Statement statement = connection.createStatement();

            // Assume we want to update a user's password
            String updatePasswordQuery = "UPDATE users SET password = 'newpassword' WHERE username = 'testuser'";
            statement.executeUpdate(updatePasswordQuery);

            // Assume we want to select a user's password
            String selectPasswordQuery = "SELECT password FROM users WHERE username = 'testuser'";
            ResultSet resultSet = statement.executeQuery(selectPasswordQuery);

            if (resultSet.next()) {
                System.out.println("User password: " + resultSet.getString("password"));
            }

            // Step 4: Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}