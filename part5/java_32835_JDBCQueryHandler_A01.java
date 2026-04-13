import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32835_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE Username = 'admin' AND Password = 'password'";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    if (resultSet.next()) {
                        System.out.println("Access granted for user: " + resultSet.getString("Username"));
                    } else {
                        System.out.println("Access denied for user: " + resultSet.getString("Username"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}