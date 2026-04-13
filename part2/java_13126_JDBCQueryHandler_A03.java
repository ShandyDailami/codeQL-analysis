import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_13126_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        Connection connection = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Execute a query
            String query = "SELECT * FROM users WHERE name = ?";
            connection.prepareStatement(query).execute(args[0]);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            // Close the connection
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