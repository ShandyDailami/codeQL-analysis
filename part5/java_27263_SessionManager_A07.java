import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27263_SessionManager_A07 {

    public static void main(String[] args) {
        createSession();
    }

    public static void createSession() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database!");

            // Try to access protected data
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM protected_data");
                while (resultSet.next()) {
                    System.out.println("Access to protected data allowed: " + resultSet.getString("data"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}