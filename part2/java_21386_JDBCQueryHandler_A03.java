import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_21386_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Run a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable WHERE mycolumn = '" + args[0] + "'");

            // Print the results
            while (resultSet.next()) {
                System.out.println("My value is: " + resultSet.getString("mycolumn"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
}