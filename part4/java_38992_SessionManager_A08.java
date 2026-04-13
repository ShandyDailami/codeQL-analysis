import java.util.HashMap;
import java.util.Map;

public class java_38992_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_38992_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String generateSessionId() {
        // This is a dummy method for generating sessionId.
        // The actual implementation may use random or hash generation methods.
        return "A08_IntegrityFailure";
    }

    // This is a placeholder method for verifying integrity of session.
    public boolean verifySessionIntegrity(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}