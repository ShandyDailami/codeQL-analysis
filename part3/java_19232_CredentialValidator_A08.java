import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_19232_CredentialValidator_A08 {

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Stored hashed password from database
    private String hashedPassword;

    public java_19232_CredentialValidator_A08(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public boolean validate(String password) {
        try {
            return arePasswordsEqual(hashPassword(password));
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    private boolean arePasswordsEqual(String hashedPassword) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.prepareStatement("SELECT password FROM users WHERE id = 1");
            rs = stmt.executeQuery();

            if (rs.next()) {
                String dbHashedPassword = rs.getString("password");
                return hashedPassword.equals(dbHashedPassword);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return false;
    }
}