import java.util.HashMap;
import java.util.Map;

public class java_41536_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_41536_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive operation related to A08_IntegrityFailure
    public void checkSessionIntegrity(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            // Session is valid, perform integrity check
            String userId = sessionMap.get(sessionId);
            // In a real-world application, we would need to validate this user against a database or another source
            // For the sake of simplicity, we'll just check if the userId is not null
            if (userId != null) {
                // User is valid, so we can proceed with the integrity check
                System.out.println("User with ID " + userId + " has a valid session with ID " + sessionId);
            } else {
                System.out.println("Invalid session with ID " + sessionId);
            }
        } else {
            System.out.println("Invalid session with ID " + sessionId);
        }
    }
}