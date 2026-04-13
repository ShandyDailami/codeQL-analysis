import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_11169_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "INSERT INTO my_table (column1, column2) VALUES ('value1', 'value2')";
            statement.executeUpdate(sql);

            System.out.println("Successfully inserted into my_table table.");

        } catch (SQLException e) {
            System.out.println("Error while connecting to database: " + e.getMessage());
        }
    }
}