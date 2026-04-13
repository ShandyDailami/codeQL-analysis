import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_38269_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare the SQL query
            String sql = "UPDATE user SET password = ? WHERE id = ?";
            pstmt = connection.prepareStatement(sql);

            // Step 4: Set parameters and execute the query
            pstmt.setString(1, "new_password"); // Hashed password
            pstmt.setInt(2, 1); // User id
            pstmt.executeUpdate();

            // Step 5: Clean up
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}