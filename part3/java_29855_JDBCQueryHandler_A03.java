import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_29855_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Register JDBC driver
            // Here, MySQL JDBC driver is used
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Perform operations on the database
            // Here, a simple query is performed
            String query = "SELECT * FROM users";
            connection.createStatement().executeQuery(query);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
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