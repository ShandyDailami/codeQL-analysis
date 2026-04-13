import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_26728_JDBCQueryHandler_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String passwordToHash = "password123";
        String salt = getSalt();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(passwordToHash.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(hash);

        System.out.println(encodedPassword);
    }

    private static String getSalt() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] salt = md.digest(Integer.toString(System.currentTimeMillis()).getBytes());
        return Base64.getEncoder().encodeToString(salt);
    }
}