import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Map;
import java.util.HashMap;

public class java_05379_SessionManager_A08 {
    private Map<String, String> sessions;
    private Key key;

    public java_05379_SessionManager_A08(String password) {
        this.sessions = new HashMap<>();
        this.key = toKey(password);
    }

    private Key toKey(String password) {
        byte[] keyBytes = password.getBytes();
        byte[] keyBytesAES = new byte[16];
        System.arraycopy(keyBytes, 0, keyBytesAES, 0, keyBytesAES.length);
        for (int i = 16; i < keyBytes.length; i++) {
            keyBytesAES[i] = keyBytesAES[i - 16];
        }
        return new SecretKeySpec(keyBytesAES, "AES");
    }

    public void addSession(String sessionId, String data) throws Exception {
        String encryptedData = encryptData(data);
        sessions.put(sessionId, encryptedData);
    }

    public String getSession(String sessionId) throws Exception {
        String encryptedData = sessions.get(sessionId);
        if (encryptedData == null) {
            throw new Exception("Invalid session id");
        }
        return decryptData(encryptedData);
    }

    private String encryptData(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new String(cipher.doFinal(data.getBytes()));
    }

    private String decryptData(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(encryptedData.getBytes()));
    }
}