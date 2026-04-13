import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class java_20033_SessionManager_A01 {
    private static final String SECRET = "my_secret_key";
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
    private static final int ITERATIONS = 65536;

    public String encrypt(String data) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] encrypted = encryptBytes(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedData) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] encrypted = Base64.getDecoder().decode(encryptedData);
        return new String(decryptBytes(encrypted));
    }

    private byte[] encryptBytes(byte[] data) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = factory.generateSecret(new PBEKeySpec(SECRET.toCharArray(), SECRET.getBytes(), ITERATIONS, 128));
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    private byte[] decryptBytes(byte[] encryptedData) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = factory.generateSecret(new PBEKeySpec(SECRET.toCharArray(), SECRET.getBytes(), ITERATIONS, 128));
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encryptedData);
    }
}