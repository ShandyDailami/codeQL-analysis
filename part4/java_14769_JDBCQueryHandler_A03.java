import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_14769_JDBCQueryHandler_A03 {

    // URL, username and password for Oracle Database
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    // Driver name
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    public static void main(String[] args) {
        // Load Oracle JDBC driver
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Establish a connection
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Example SQL query
            String query = "SELECT * FROM employees WHERE name = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, "John");

            // Execute the prepared statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statements
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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