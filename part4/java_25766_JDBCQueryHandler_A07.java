import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_25766_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare the SQL query
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters
            statement.setString(1, "username");
            statement.setString(2, "password");

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set is empty
            if (resultSet.isEmpty()) {
                System.out.println("Invalid username or password");
            } else {
                System.out.println("Valid user");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}