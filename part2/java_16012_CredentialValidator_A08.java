import java.security.InvalidParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_16012_CredentialValidator_A08 {

    // The secret key is used for encryption and decryption.
    private SecretKey secretKey;

    // The cipher used for encryption and decryption.
    private Cipher cipher;

    // The MessageDigest is used to generate a hash of the password.
    private MessageDigest messageDigest;

    public java_16012_CredentialValidator_A08() {
        try {
            // Generate a new secret key.
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            secretKey = keyGenerator.generateKey();

            // Create a cipher that uses the secret key for encryption.
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Create a new MessageDigest for hashing passwords.
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String hashPassword(String password) {
        byte[] hashedPassword = messageDigest.digest(password.getBytes());
        return bytesToHex(hashedPassword);
    }

    public boolean isValidPassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }

    public byte[] encryptPassword(String password) {
        byte[] passwordBytes = password.getBytes();
        byte[] encryptedPasswordBytes = cipher.doFinal(passwordBytes);
        return encryptedPasswordBytes;
    }

    public String decryptPassword(byte[] encryptedPasswordBytes) {
        byte[] decryptedPasswordBytes = cipher.doFinal(encryptedPasswordBytes);
        return new String(decryptedPasswordBytes);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}