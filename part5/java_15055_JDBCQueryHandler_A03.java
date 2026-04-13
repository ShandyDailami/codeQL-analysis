import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_15055_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Insecure way of executing a SQL statement without prepared statements
            String insecureSql = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(insecureSql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            // Secure way of executing a SQL statement with prepared statements
            String secureSql = "SELECT * FROM Users WHERE username = ?";
            ResultSet secureResultSet = statement.executeQuery(secureSql, "admin");

            while (secureResultSet.next()) {
                System.out.println(secureResultSet.getString("username"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}