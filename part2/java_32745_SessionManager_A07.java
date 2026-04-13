import java.util.HashMap;
import java.util.Map;

public class java_32745_SessionManager_A07 {

    // A secure session store
    private Map<String, String> sessionStore;

    public java_32745_SessionManager_A07() {
        this.sessionStore = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate if a session is valid
    public boolean validateSession(String sessionId) {
        return sessionStore.containsKey(sessionId);
    }

    // Method to get userId from a session
    public String getUserIdFromSession(String sessionId) {
        if (validateSession(sessionId)) {
            return sessionStore.get(sessionId);
        } else {
            throw new AuthFailureException("Invalid session");
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    // A simple session id generation method
    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }

}