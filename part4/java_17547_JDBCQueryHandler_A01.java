import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17547_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM mytable";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Row 1: " + resultSet.getString("column1"));
                System.out.println("Row 2: " + resultSet.getString("column2"));
                // and so on...
            }
        } catch (SQLException e) {
            System.out.println("Error processing query: " + e.getMessage());
        }
    }
}