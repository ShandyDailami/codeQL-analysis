import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05444_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Here you could use a JDBC statement to execute queries, for example:
            String selectQuery = "SELECT * FROM users";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                }
            }

            // Here you could use a JDBC prepared statement to avoid SQL injection
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, "newuser");
                preparedStatement.setString(2, "newpassword");
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}