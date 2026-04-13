import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_41184_CredentialValidator_A07 {

    private Key key;

    public java_41184_CredentialValidator_A07(String keyString) {
        try {
            key = MessageDigest.getInstance("SHA-1").digest(keyString.getBytes());
        } catch (NoSuchAlgorithmException e) {
            // Handle exception here. The keyString parameter is required.
        }
    }

    public boolean validateCredential(String keyString, String presentedPassword) {
        try {
            byte[] keyBytes = key.getBytes();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(keyBytes);
            byte[] hashedPassword = md.digest(presentedPassword.getBytes());
            return MessageDigest.isEqual(hashedPassword, key);
        } catch (NoSuchAlgorithmException e) {
            // Handle exception here. The presentedPassword parameter is required.
        }
        return false;
    }

}