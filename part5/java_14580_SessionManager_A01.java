import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_14580_SessionManager_A01 {
    private static final String ALGORITHM = "AES";

    public static SecretKey generateKey() throws Exception {
        Key key = KeyGenerator.getInstance(ALGORITHM).generateKey();
        return new SecretKeySpec(key.getEncoded(), ALGORITHM);
    }

    public static String encrypt(String data, SecretKey key) throws Exception {
        byte[] is = data.getBytes("UTF-8");
        return Base64.getEncoder().encodeToString(encrypt(is, key));
    }

    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        byte[] cipherData = Base64.getDecoder().decode(encryptedText);
        byte[] decodedBytes = decrypt(cipherData, key);
        return new String(decodedBytes, "UTF-8");
    }

    private static byte[] decrypt(byte[] cipherData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherData);
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = generateKey();
        System.out.println("Key: " + new String(key.getEncoded()));

        String data = "This is a sensitive operation!";
        System.out.println("Original: " + data);

        String encrypted = encrypt(data, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
    }
}