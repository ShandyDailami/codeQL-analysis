import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_10253_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // You'll need to replace these with your actual credentials
        String username = "your_username";
        String password = "your_password";
        String url = "jdbc:mysql://localhost:3306/mydatabase";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "user1");
            statement.setString(2, "password1");

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}