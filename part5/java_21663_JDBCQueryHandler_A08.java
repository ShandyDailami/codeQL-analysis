import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

public class java_21663_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Establish a database connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Prepare SQL statement
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Step 3: Execute SQL statement with a hashed password
            String hashedPassword = BCrypt.hashpw("myPassword", BCrypt.gensalt());
            pstmt.setString(1, "username");
            pstmt.setString(2, hashedPassword);
            pstmt.executeUpdate();

            // Step 4: Clean up
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}