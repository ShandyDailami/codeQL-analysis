import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22347_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection to database established");
        } catch (SQLException e) {
            System.out.println("Error while connecting to database");
            e.printStackTrace();
        }
    }
}