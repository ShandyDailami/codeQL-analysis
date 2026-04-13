import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_12960_SessionManager_A03 {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "12345678abcdefgh"; // 128 bit key

    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String username) {
        String encodedKey = new String(Base64.getEncoder().encode(KEY.getBytes()));
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encodedKey.getBytes(), ALGORITHM));
            String encryptedSessionId = Base64.getEncoder().encodeToString(cipher.doFinal(username.getBytes()));
            sessions.put(encryptedSessionId, username);
            return encryptedSessionId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getSession(String encryptedSessionId) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Base64.getDecoder().decode(KEY), ALGORITHM));
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedSessionId)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}