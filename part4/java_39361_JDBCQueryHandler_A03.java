import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class java_39361_JDBCQueryHandler_A03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password1 = "password";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            System.out.println("Connected to database!");

            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            java.sql.ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                System.out.println("Username from database: " + dbUsername);
                System.out.println("Password from database: " + dbPassword);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}