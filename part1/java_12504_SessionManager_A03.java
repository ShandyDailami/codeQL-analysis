import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.Map;

public class java_12504_SessionManager_A03 {
    private Map<String, String> sessionData;

    public java_12504_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionData.put(sessionId, userId);
        System.out.println("Session started with ID: " + sessionId + " and User ID: " + userId);
    }

    public void endSession(String sessionId) {
        sessionData.remove(sessionId);
        System.out.println("Session ended with ID: " + sessionId);
    }

    public String getUserId(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
            return null;
        }
    }
}