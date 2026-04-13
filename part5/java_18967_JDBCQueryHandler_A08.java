import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_18967_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "testUser");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String dbUsername = result.getString("username");
                String dbPassword = result.getString("password");
                System.out.println("Username: " + dbUsername);
                System.out.println("Password: " + dbPassword);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}