import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_32228_SessionManager_A01 {
    private String secret;

    public java_32228_SessionManager_A01(String secret) {
        this.secret = secret;
    }

    public String encrypt(String plainText) {
        byte[] plainTextByte = plainText.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainTextByte);
            byte[] messageDigest = md.digest();
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return plainText;
    }

    public String secureLogin(String username, String password) {
        String hashedPassword = encrypt(password);
        // Here you would typically compare the hashed password with a stored hashed password
        // For this example, we'll just return the hashed password.
        return hashedPassword;
    }
}