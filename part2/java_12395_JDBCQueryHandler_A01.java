import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12395_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'");

            if (resultSet.next()) {
                System.out.println("Access granted for user: " + resultSet.getString("username"));
            } else {
                System.out.println("Access denied");
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}