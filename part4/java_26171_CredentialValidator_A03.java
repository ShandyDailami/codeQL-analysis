import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_26171_CredentialValidator_A03 {
    private final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private final String USER = "root";
    private final String PASS = "password";

    public boolean validate(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String encryptedPassword = getEncryptedPassword(password);

            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, encryptedPassword);
                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private String getEncryptedPassword(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = md.digest(password.getBytes());

        return new String(hash);
    }
}