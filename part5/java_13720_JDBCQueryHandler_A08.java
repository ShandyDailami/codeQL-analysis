import java.sql.*;
import java.util.Scanner;

public class java_13720_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.next();

        System.out.println("Enter password:");
        String password = scanner.next();

        String url = "jdbc:mysql://localhost:3306/mydatabase"; // replace with your actual database URL
        String driver = "com.mysql.jdbc.Driver"; // replace with your actual MySQL JDBC driver

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String query = "SELECT * FROM Users WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(url, "username", "password");
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (password.equals(dbPassword)) {
                    System.out.println("Welcome, " + username + "!");
                } else {
                    System.out.println("Incorrect username or password!");
                }
            } else {
                System.out.println("Incorrect username or password!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}