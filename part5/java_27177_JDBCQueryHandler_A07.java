import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27177_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Set up the database connection
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            try {
                // Step 2: Perform security-sensitive operation
                String query = "SELECT * FROM users WHERE username = ?";
                connection.prepareStatement(query).setString(1, "admin");

                // Step 3: Execute the query
                // ...
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Step 4: Close the database connection
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}