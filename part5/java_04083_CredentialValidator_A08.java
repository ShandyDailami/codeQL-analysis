import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_04083_CredentialValidator_A08 {
    private Connection conn;

    public java_04083_CredentialValidator_A08(Connection conn) {
        this.conn = conn;
    }

    public boolean validate(String username, String password) throws NoSuchAlgorithmException {
        String hashedPassword = getHashedPassword(username);
        if (hashedPassword == null) {
            throw new NoSuchAlgorithmException("No password found for user " + username);
        }

        return isPasswordMatch(hashedPassword, password);
    }

    private String getHashedPassword(String username) throws NoSuchAlgorithmException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT password FROM Users WHERE username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private boolean isPasswordMatch(String hashedPassword, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hashedAttempt = sb.toString();
        return hashedAttempt.equals(hashedPassword);
    }
}