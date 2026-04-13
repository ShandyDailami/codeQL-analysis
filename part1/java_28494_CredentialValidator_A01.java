import java.util.Base64;
import java.util.Arrays;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_28494_CredentialValidator_A01 {
    public boolean validate(String plainText, String encryptedText) {
        byte[] encrypted = Base64.getDecoder().decode(encryptedText);
        byte[] plain = plainText.getBytes();

        // Fake password check
        if (Arrays.equals(encrypted, this.hashPassword(plain))) {
            return true;
        }

        return false;
    }

    private byte[] hashPassword(byte[] password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(password);
        } catch (NoSuchAlgorithmException e) {
            // handle exception
        }

        return null;
    }
}