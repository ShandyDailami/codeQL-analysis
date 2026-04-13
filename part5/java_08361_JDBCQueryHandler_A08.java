import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class java_08361_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter database URL:");
        String url = scanner.nextLine();

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");

            System.out.println("Enter SQL query:");
            String query = scanner.nextLine();

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    System.out.println("Result: " + resultSet.getString("ColumnName"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }

        scanner.close();
    }
}