import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_31531_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Example of a query
            String selectQuery = "SELECT * FROM Users";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    System.out.println("User ID: " + resultSet.getInt("id"));
                    System.out.println("User Name: " + resultSet.getString("name"));
                    System.out.println("User Email: " + resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }
}