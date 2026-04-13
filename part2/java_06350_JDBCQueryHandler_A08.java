import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06350_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Here's a security-sensitive operation. Accessing sensitive data.
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sensitive_data");

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                // Here's another security-sensitive operation. Accessing sensitive data.
                String column2 = resultSet.getString("column2");
                System.out.println(column1 + ", " + column2);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}