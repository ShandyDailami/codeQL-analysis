import java.sql.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_08663_JDBCQueryHandler_A07 {
    private static final String url = "jdbcUrl";
    private static final String username = "username";
    private static final String password = "password";

    private static final String key = "cryptoKey"; // key used for encryption/decryption

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE username = ?";
        String encryptedPassword = encryptPassword(password); // encrypted password

        try (Connection conn = DriverManager.getConnection(url, username, encryptedPassword);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "user"); // user input

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encryptPassword(String password) {
        Key key = new SecretKeySpec(key.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return new String(cipher.doFinal(password.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}