import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_07471_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        String query = "SELECT * FROM Users WHERE ID = ?";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter
            preparedStatement.setInt(1, 123);

            // Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String name = resultSet.getString("Name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}