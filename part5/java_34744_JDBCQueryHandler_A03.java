import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_34744_JDBCQueryHandler_A03 {

    // URL, username, and password for a MySQL database
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL statement
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Set parameters and execute the statement
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");
            pstmt.executeUpdate();

            // Step 5: Clean up
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}