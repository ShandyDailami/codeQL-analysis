import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39311_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        // Step 1: Setup the database connection
        String url = "jdbc:your_db_url";
        String username = "your_username";
        String password = "your_password";

        Connection connection = null;

        try {
            // Step 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Establish the database connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 4: Execute a query
            String query = "SELECT * FROM your_table";
            connection.createStatement().executeQuery(query);

            // Step 5: Close the database connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}