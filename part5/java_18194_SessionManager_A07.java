import java.util.HashMap;
import java.util.Map;

public class java_18194_SessionManager_A07 {
    // In a real-world application, this would be a Database or another form of persistence.
    private Map<String, String> sessionMap = new HashMap<>();

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Created session with ID: " + sessionId + ", User ID: " + userId);
    }

    public void closeSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            System.out.println("Closed session with ID: " + sessionId + ", User ID: " + userId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }
}