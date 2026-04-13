import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_39053_SessionManager_A08 {

    private Map<String, String> sessions;

    public java_39053_SessionManager_A08() {
        sessions = new ConcurrentHashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        String data = encryptData(username);
        sessions.put(sessionId, data);
        return sessionId;
    }

    public String getSessionData(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        return Base64.getUrlEncoder().encodeToString(java.util.UUID.randomUUID().toString().getBytes());
    }

    private String encryptData(String data) {
        // For simplicity, we will encrypt the data using Base64. For real use cases, you may use a more secure encryption method.
        byte[] encodedBytes = Base64.getEncoder().encode(data.getBytes());
        return new String(encodedBytes);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("John");
        System.out.println("Created session with ID: " + sessionId);

        String data = sessionManager.getSessionData(sessionId);
        System.out.println("Session data: " + data);

        sessionManager.deleteSession(sessionId);
    }
}