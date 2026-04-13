import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_30095_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb"; // replace with your database details
    private static final String username = "username"; // replace with your username
    private static final String password = "password"; // replace with your password

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(url, username, password);

            // Perform integrity check
            String query = "SELECT * FROM Users WHERE username = ?";
            connection.prepareStatement(query).execute(args[0]);

            System.out.println("Operation succeeded");
        } catch (SQLException | ClassNotFoundException e) {
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