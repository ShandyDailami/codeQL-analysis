import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_33290_SessionManager_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        // Step 1: Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3: Use the connection (session)
        if (connection != null) {
            // Here you can use the connection for your operations
            // For example, you can insert, update, delete, or query data
            // ...

            // Step 4: Close the connection
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}