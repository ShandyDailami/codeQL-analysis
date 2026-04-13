import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_38159_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password"; // Password should be changed for security purposes

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Assuming username is 'testUser' and password is 'password'
            preparedStatement.setString(1, "testUser");
            preparedStatement.setString(2, "password");

            preparedStatement.executeUpdate();

            System.out.println("User inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error while connecting to database: " + e.getMessage());
        }
    }
}