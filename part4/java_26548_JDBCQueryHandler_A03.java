import java.sql.*;
import java.util.Scanner;

public class java_26548_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // This is a security-sensitive operation related to A03_Injection.
        // We're using PreparedStatement for the injection attack.
        try (Connection connection = DriverManager.getConnection("jdbc:yourDatabaseDriver", "username", "password")) {
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}