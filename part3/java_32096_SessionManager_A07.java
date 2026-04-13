import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_32096_SessionManager_A07 {
    private static final String SECRET_KEY = "A07_AuthFailure"; // Secret key for encryption

    private Key generateKey() throws Exception {
        Key key;
        key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        return key;
    }

    private Cipher.getInstance("AES");

    public String encrypt(String value) throws Exception {
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
        String encryptedValue = Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes("UTF-8")));
        return encryptedValue;
    }

    public String decrypt(String encryptedText) throws Exception {
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(original, "UTF-8");
    }

    private Cipher getCipher(int mode) throws Exception {
        Key key = generateKey();
        return Cipher.getInstance("AES");
    }

    public static void main(String[] args) {
        SecureSessionManager manager = new SecureSessionManager();
        String originalText = "Hello, World!";
        System.out.println("Original Text: " + originalText);

        String encryptedText;
        try {
            encryptedText = manager.encrypt(originalText);
            System.out.println("Encrypted Text: " + encryptedText);
            String decryptedText = manager.decrypt(encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}