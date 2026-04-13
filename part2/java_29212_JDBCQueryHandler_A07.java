import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_29212_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Perform some operations
            performOperations(conn);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void performOperations(Connection conn) {
        try {
            // Example of a query
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            conn.prepareStatement(query).setString(1, "test").setString(2, "password").executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}