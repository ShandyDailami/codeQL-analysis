import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_35340_JDBCQueryHandler_A03 {

    // This is a placeholder for your actual database URL, username and password.
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Step 3: Create a SQL query
            String query = "SELECT * FROM users WHERE username = ?";

            // Step 4: Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 5: Set the parameter
            preparedStatement.setString(1, "testUser");

            // Step 6: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 7: Handle the result
            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // Step 8: Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}