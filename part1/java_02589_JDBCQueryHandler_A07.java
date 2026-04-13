import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02589_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Failed to connect to the database!");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}