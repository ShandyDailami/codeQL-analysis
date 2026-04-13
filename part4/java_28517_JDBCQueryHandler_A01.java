import java.sql.*;
import org.mindrace.crypto.BCrypt;

public class java_28517_JDBCQueryHandler_A01 {

    private Connection conn;

    public java_28517_JDBCQueryHandler_A01(String dbURL, String username, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(String username, String password) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, passwordHash);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyUser(String username, String password) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT password FROM users WHERE username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String dbPassword = rs.getString(1);
                return BCrypt.checkpw(password, dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}