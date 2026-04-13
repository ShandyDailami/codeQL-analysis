import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18866_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");

            String sql = "SELECT * FROM my_table";
            // no SQL Injection here.

            // perform a query
            // ...

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }
}