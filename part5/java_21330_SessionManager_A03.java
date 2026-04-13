import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class java_21330_SessionManager_A03 {

    private static final String ALGORITHM = "AES";
    private static final String KEY = "12345678abcdefgh";

    private Map<String, String> store = new HashMap<>();

    public String createSession(String userId) throws Exception {
        String sessionId = generateSessionId();
        String encryptedData = encrypt(userId);
        store.put(sessionId, encryptedData);
        return sessionId;
    }

    public String getUserId(String sessionId) throws Exception {
        String encryptedData = store.get(sessionId);
        if (encryptedData == null) {
            return null;
        }
        return decrypt(encryptedData);
    }

    private String generateSessionId() {
        return String.valueOf(System.nanoTime());
    }

    private String encrypt(String value) throws Exception {
        Key key = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
    }

    private String decrypt(String value) throws Exception {
        Key key = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(value)));
    }
}