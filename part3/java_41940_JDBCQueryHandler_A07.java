import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_41940_JDBCQueryHandler_A07 {

    // Provided details for database access
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    // Secure query
    private static final String SECURE_QUERY = "SELECT * FROM users WHERE username='user' AND password='pass'";

    public static void main(String[] args) {

        // Load the driver
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish a connection
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Try to execute the secure query
            try (ResultSet resultSet = statement.executeQuery(SECURE_QUERY)) {
                if (resultSet.next()) {
                    System.out.println("Authentication succeeded");
                } else {
                    System.out.println("Authentication failed");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}