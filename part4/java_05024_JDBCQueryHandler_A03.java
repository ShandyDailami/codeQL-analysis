import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05024_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Perform a query
            String query = "SELECT * FROM mytable";
            connection.createStatement().executeQuery(query);

            // Step 4: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found: " + e.getMessage());
        }
    }
}