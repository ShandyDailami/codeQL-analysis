import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_15295_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            // Execute SQL query
            statement.executeUpdate("CREATE TABLE users (username VARCHAR(255) NOT NULL, " +
                    "password VARCHAR(255) NOT NULL, PRIMARY KEY(username))");
            statement.executeUpdate("INSERT INTO users (username, password) VALUES ('user1', 'password1')");
            statement.executeUpdate("INSERT INTO users (username, password) VALUES ('user2', 'password2')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}