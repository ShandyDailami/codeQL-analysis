import java.sql.*;
import java.util.Scanner;

public class java_19408_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        try {
            connectToDatabase(username);
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database.");
            e.printStackTrace();
        }
    }

    private static void connectToDatabase(String username) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String usernameDB = "root";
        String passwordDB = "password";

        Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);

        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String password = resultSet.getString("password");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        statement.close();
        connection.close();
    }
}