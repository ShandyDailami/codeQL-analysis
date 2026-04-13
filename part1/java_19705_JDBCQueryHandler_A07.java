import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19705_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myUser";
    private static final String PASSWORD = "myPassword";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Perform a security-sensitive operation (e.g., authentication)
            // Here, we are just checking the connection
            if (connection.isValid(5)) {
                System.out.println("Connection is valid.");
            } else {
                System.out.println("Connection is not valid.");
            }

            // Step 4: Disconnect from the database
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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