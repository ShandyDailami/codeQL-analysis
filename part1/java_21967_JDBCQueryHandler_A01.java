import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_21967_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Here we assume a SQL query to select a user by ID.
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter for the user ID.
            preparedStatement.setInt(1, 1001);

            // Execute the query.
            preparedStatement.execute();

            // Close the connection.
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}