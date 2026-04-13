import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_23593_SessionManager_A08 {
    private Map<String, String> sessions;
    private Map<String, byte[]> encryptedData;

    public java_23593_SessionManager_A08() {
        sessions = new HashMap<>();
        encryptedData = new HashMap<>();
    }

    public String createSession(String userId) {
        try {
            String sessionId = getMd5Hash(userId);
            sessions.put(sessionId, userId);
            return sessionId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String getMd5Hash(String input) {
        String md5String;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            md5String = bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return md5String;
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    // Add more methods for encrypting and decrypting data if needed
}