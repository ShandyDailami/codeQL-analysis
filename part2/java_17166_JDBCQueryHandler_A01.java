import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17166_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("mycolumn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}