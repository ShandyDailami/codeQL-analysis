import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17917_JDBCQueryHandler_A01 {

    public static final String URL = "jdbc:mysql://localhost:3306/mydb";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = 'admin'";
            try (Statement statement = connection.createStatement();
                 ResultSet result = statement.executeQuery(query)) {

                while (result.next()) {
                    String username = result.getString("username");
                    String password = result.getString("password");
                    // Do something with the username and password
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}