import java.security.SecureRandom;
import java.util.Base64;

public class java_41414_SessionManager_A08 {
    private SecureRandom random = new SecureRandom();
    private String algorithm = "AES";
    private int keysize = 256;

    public String encrypt(String plainText) {
        byte[] encryptedBytes = null;
        byte[] keyBytes = new byte[16];
        random.nextBytes(keyBytes);

        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(algorithm);
        javax.crypto.Cipher cipher = keyGenerator.createCipher(algorithm, keyBytes);
        encryptedBytes = cipher.doFinal(plainText.getBytes());

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedText) throws Exception {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] keyBytes = new byte[16];
        random.nextBytes(keyBytes);

        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(algorithm);
        javax.crypto.Cipher cipher = keyGenerator.createCipher(algorithm, keyBytes);
        return new String(cipher.doFinal(encryptedBytes));
    }
}