import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_24074_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the SQL query
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "testUser");
            statement.setString(2, "testPassword");

            // Step 3: Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery();

            // Step 4: Handle the result
            while (resultSet.next()) {
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                System.out.println("Username: " + dbUsername);
                System.out.println("Password: " + dbPassword);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}