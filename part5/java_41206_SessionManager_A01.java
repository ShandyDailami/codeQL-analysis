import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class java_41206_SessionManager_A01 {
    private static final String AES = "AES";
    private static final String KEY = "12345678abcdefgh"; // 32 bytes = 44 bytes for AES

    public String encrypt(String value) throws Exception {
        Key key = new SecretKeySpec(KEY.getBytes(), AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        String encryptedValue = Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
        return encryptedValue;
    }

    public String decrypt(String encryptedValue) throws Exception {
        Key key = new SecretKeySpec(KEY.getBytes(), AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        return new String(decryptedValue);
    }
}