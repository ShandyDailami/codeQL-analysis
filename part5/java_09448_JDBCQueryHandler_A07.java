import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_09448_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Set up a connection to the database
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Prepare the SQL query
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set parameters and execute the query
        try {
            statement.setString(1, "testuser");
            statement.setString(2, "testpassword");
            ResultSet result = statement.executeQuery();

            // Process the result
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("User " + username + " logged in successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Close the connection
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}