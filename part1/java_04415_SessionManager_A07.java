import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class java_04415_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_04415_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) throws EntityNotFoundException {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new EntityNotFoundException("Session not found");
        }
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void authenticate(String sessionId, String password) throws AuthenticationFailureException {
        String expectedPassword = getUserPassword(sessionId);
        if (password.equals(expectedPassword)) {
            // Authentication successful
        } else {
            // Authentication failed
            throw new AuthenticationFailureException("Authentication failed");
        }
    }

    private String getUserPassword(String sessionId) {
        // This method should retrieve the password from the database or other secure storage
        // Replace with actual implementation
        return "dummyPassword";
    }
}