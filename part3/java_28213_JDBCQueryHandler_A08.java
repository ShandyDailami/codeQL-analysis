import java.sql.*;
import java.util.Scanner;

public class java_28213_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the password:");
        String enteredPassword = scanner.next();

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE username = 'admin'");

            if (resultSet.next()) {
                String dbPassword = resultSet.getString(1);

                if (enteredPassword.equals(dbPassword)) {
                    System.out.println("Access granted");
                } else {
                    System.out.println("Access denied. Password mismatch");
                }
            } else {
                System.out.println("Access denied. No user found");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}