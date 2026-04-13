import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05026_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = '" + "username" + "'");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                if (username.equals("username") && password.equals("password")) {
                    System.out.println("User authenticated successfully");
                } else {
                    System.out.println("User authentication failed");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}