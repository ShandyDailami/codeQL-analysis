import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class java_35373_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your SQL Query:");
        String query = scanner.nextLine();
        scanner.close();

        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Replace with your database info
        String username = "root"; // Replace with your username
        String password = "password"; // Replace with your password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("Result: " + resultSet.getString("column_name"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}