import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28391_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Connect to the database
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // Step 2: Execute a query
            String query = "SELECT * FROM users WHERE username = 'bad_user' AND password = 'bad_password'";
            statement.executeQuery(query);

            // Step 3: Disconnect from the database
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}