import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class java_04467_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.next();

        System.out.println("Enter password:");
        String password = scanner.next();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", username, password)) {
            System.out.println("Logged in successfully");
        } catch (SQLException e) {
            System.out.println("Failed to log in");
            e.printStackTrace();
        }
    }
}