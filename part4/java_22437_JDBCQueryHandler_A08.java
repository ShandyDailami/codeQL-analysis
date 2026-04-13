import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22437_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if (connection != null) {
                System.out.println("Connection to database established.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while trying to connect to the database.");
            e.printStackTrace();
        }
    }
}