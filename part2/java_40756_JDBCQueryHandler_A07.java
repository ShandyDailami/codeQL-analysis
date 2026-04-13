import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_40756_JDBCQueryHandler_A07 {

    private Connection conn;

    public java_40756_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public boolean authenticate(String username, String password) throws NoSuchAlgorithmException {
        String hashedPassword = getHashedPassword(password);

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT password FROM users WHERE username = ?");
            if (rs.next()) {
                return hashedPassword.equals(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private String getHashedPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}