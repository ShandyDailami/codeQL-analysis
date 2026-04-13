import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_24723_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Provide the database connection information
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM my_table WHERE my_column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the value for the parameter
            preparedStatement.setString(1, "my_value");

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Process the result set
                System.out.println(resultSet.getString("my_column"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}