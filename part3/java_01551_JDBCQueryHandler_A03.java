import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01551_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Perform SQL query
            String query = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            connection.prepareStatement(query).execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close connection
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