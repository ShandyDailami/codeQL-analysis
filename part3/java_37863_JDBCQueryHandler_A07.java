import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37863_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // replace with your database url
        String username = "root"; // replace with your username
        String password = "password"; // replace with your password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database!");

            String query = "SELECT * FROM Users"; // replace with your query
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}