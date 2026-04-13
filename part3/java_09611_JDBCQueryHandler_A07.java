import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09611_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Perform query here
            String query = "SELECT * FROM users";
            connection.createStatement().execute(query);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection
            if (connection != null) {
                connection.close();
            }
        }
    }
}