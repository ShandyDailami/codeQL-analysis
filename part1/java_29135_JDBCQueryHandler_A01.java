import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29135_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Fetch data for user A
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE role = 'admin'");
            while (resultSet.next()) {
                System.out.println("User A is authorized to access the data: " + resultSet.getString("name"));
            }

            // Fetch data for user B
            resultSet = statement.executeQuery("SELECT * FROM users WHERE role = 'user'");
            while (resultSet.next()) {
                System.out.println("User B is authorized to access the data: " + resultSet.getString("name"));
            }

            // Fetch data for user C
            resultSet = statement.executeQuery("SELECT * FROM users WHERE role = 'guest'");
            while (resultSet.next()) {
                System.out.println("User C is authorized to access the data: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}