import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class java_33339_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private Random random;

    public java_33339_SessionManager_A08() {
        sessionMap = new HashMap<>();
        random = new Random();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) throws IntegrityFailureException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IntegrityFailureException("Invalid session ID");
        }
        return sessionMap.get(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(random.nextInt(1000000000)); // Assumes IDs are 9 digits
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class IntegrityFailureException extends Exception {
        public java_33339_SessionManager_A08(String message) {
            super(message);
        }
    }
}