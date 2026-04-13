import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_38175_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM users WHERE id = " + args[0];
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String passwordFromDb = resultSet.getString("password");
                System.out.println("Retrieved password from database: " + passwordFromDb);
            } else {
                System.out.println("No user found with the provided ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}