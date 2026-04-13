import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_32295_SessionManager_A08 {
    private final Map<String, String> sessions = new HashMap<>();
    private final SecureRandom random = new SecureRandom();

    public String createSession(String user) {
        String sessionId;
        do {
            // Create a 16 byte (32 bit) random ID
            byte[] randomBytes = new byte[16];
            random.nextBytes(randomBytes);
            // Convert the byte array to a hexadecimal string
            sessionId = bytesToHex(randomBytes);
        } while (sessions.containsKey(sessionId));

        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}