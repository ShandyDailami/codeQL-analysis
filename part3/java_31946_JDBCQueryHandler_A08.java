import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31946_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE email LIKE '%@domain.com' AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "password");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String passwordDB = resultSet.getString("password");

                System.out.println("Email: " + email);
                System.out.println("Password in the database: " + passwordDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}