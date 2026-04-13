import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_41501_JDBCQueryHandler_A07 {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a PreparedStatement
            preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");

            // Step 4: Set the parameter value
            preparedStatement.setString(1, "testUser");

            // Step 5: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 6: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Cleanup
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}