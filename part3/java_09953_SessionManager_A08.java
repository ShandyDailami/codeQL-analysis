import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_09953_SessionManager_A08 {
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "12345678abcdefgh".getBytes();

    public static String encrypt(String value) throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes("UTF-8")));
    }

    public static String decrypt(String encryptedValue) throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedValue)), "UTF-8");
   
    }

    // Test the methods
    public static void main(String[] args) throws Exception {
        String value = "This is a test message";
        String encryptedValue = encrypt(value);
        System.out.println("Encrypted value: " + encryptedValue);
        String decryptedValue = decrypt(encryptedValue);
        System.out.println("Decrypted value: " + decryptedValue);
    }
}