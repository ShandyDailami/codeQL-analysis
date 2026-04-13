import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_33760_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Example of a security sensitive operation
            String selectQuery = "SELECT * FROM Users WHERE Username = 'username'";

            connection.prepareStatement(selectQuery).execute();

        } catch (SQLException e) {
            System.out.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }
}