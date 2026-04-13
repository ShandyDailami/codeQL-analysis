import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_28437_CredentialValidator_A08 {

    private static final String ALGORITHM = "AES";
    private static final String KEY = "12345678abcdefgh"; // 128 bit key

    public String encrypt(String data) {
        byte[] keyBytes = KEY.getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decrypt(String data) {
        byte[] keyBytes = KEY.getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(data));
            return new String(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}