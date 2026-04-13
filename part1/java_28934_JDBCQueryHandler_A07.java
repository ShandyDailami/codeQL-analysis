import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_28934_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Create a statement
            String query = "SELECT * FROM Users WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);

            // Step 4: Set the parameter value
            preparedStatement.setInt(1, 123);

            // Step 5: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 6: Process the result set
            while (resultSet.next()) {
                System.out.println("User id: " + resultSet.getInt("id"));
                System.out.println("User name: " + resultSet.getString("name"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the statements and connections
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}