import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_22712_JDBCQueryHandler_A01 {

    private Connection conn;

    public java_22712_JDBCQueryHandler_A01(String dbURL, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, user, password);
    }

    public boolean checkPassword(String user, String password) {
        String hashedPassword = getPasswordHash(password);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username ='" + user + "'");
            if (rs.next()) {
                return hashedPassword.equals(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        }
        return false;
    }

    private String getPasswordHash(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: No SHA-256 algorithm.");
        }
        return null;
    }
}