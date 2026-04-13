import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_02868_JDBCQueryHandler_A07 {

    // Define your database URL, username, and password here.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load the driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare statement for update operation
            pstmt = conn.prepareStatement("UPDATE my_table SET my_column = ? WHERE id = ?");

            // Set the value
            pstmt.setString(1, "new_value");
            pstmt.setInt(2, 123);

            // Execute the statement
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Always close the statement, regardless of exceptions
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    // Ignore close errors
                }
            }

            // Always close the connection, regardless of exceptions
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // Ignore close errors
                }
            }
        }
    }
}