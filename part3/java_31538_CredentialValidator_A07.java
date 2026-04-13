import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.management.AuthenticationFailedException;

public class java_31538_CredentialValidator_A07 {

    // Secret Key for Encryption/Decryption
    private static final String SECRET_KEY = "A_SECRET_KEY";

    // Cipher Mode
    private static final String CIPHER_MODE = "AES/ECB/PKCS5Padding";

    private Map<String, String> userCredentials;

    public java_31538_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        userCredentials.put(username, encryptedPassword);
    }

    public boolean validateCredentials(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            throw new AuthenticationFailedException("User does not exist");
        }

        String encryptedPassword = userCredentials.get(username);
        String decryptedPassword = decryptPassword(encryptedPassword);

        return password.equals(decryptedPassword);
    }

    private String encryptPassword(String password) {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String decryptPassword(String encryptedPassword) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedPassword)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}