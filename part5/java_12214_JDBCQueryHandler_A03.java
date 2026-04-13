import java.sql.*;
import org.mindrot.jbcrypt.*;

public class java_12214_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            // Example of inserting a new user
            String passwordToHash = "password123";
            String hashedPassword = BCrypt.hashpw(passwordToHash, BCrypt.gensalt());
            String sql = "INSERT INTO users (username, password) VALUES ('user1', '" + hashedPassword + "')";
            stmt.executeUpdate(sql);

            // Example of selecting a user
            String username = "user1";
            String sql2 = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                String dbPassword = rs.getString("password");
                if (BCrypt.checkpw(passwordToHash, dbPassword)) {
                    System.out.println("Password matched");
                } else {
                    System.out.println("Password did not match");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}