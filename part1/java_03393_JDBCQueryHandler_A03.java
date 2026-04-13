import java.sql.*;
import java.util.Scanner;

public class java_03393_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/testdb"; // your database url
        String usernameDB = "root"; // your database username
        String passwordDB = "password"; // your database password

        try {
            Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username ='" + username + "'");

            if (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            } else {
                System.out.println("User not found");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}