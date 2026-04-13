import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_29591_SessionManager_A08 {
    private final Map<String, String> sessionMap;
    private final SecureRandom random;

    public java_29591_SessionManager_A08() {
        sessionMap = new HashMap<>();
        random = new SecureRandom();
    }

    public String createSession() {
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        String sessionId = Base64.getEncoder().encodeToString(bytes);
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean integrityCheck(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        String sessionId = manager.createSession();
        System.out.println("Created session with ID: " + sessionId);

        // Get the session
        String retrievedSessionId = manager.getSession(sessionId);
        System.out.println("Retrieved session with ID: " + retrievedSessionId);

        // Integrity check
        boolean integrityCheck = manager.integrityCheck(sessionId);
        System.out.println("Integrity check: " + integrityCheck);

        // Delete the session
        manager.deleteSession(sessionId);
        System.out.println("Deleted session with ID: " + sessionId);
    }
}