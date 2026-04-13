import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_23549_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Update a user
            String updateUserQuery = "UPDATE users SET password = 'newPassword' WHERE username = 'user1'";
            statement.executeUpdate(updateUserQuery);

            // Close the connection
            statement.close();
            connection.close();

            System.out.println("User updated successfully");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}