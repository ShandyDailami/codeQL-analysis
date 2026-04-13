import java.util.HashMap;
import java.util.Map;

public class java_33880_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_33880_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID " + sessionId + " already exists. Please use a different session ID.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session with ID " + sessionId + " has started. User ID: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session with ID " + sessionId + " has ended. User ID: " + userId);
        } else {
            System.out.println("No session with ID " + sessionId + " found.");
        }
    }

    public void getSessionUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("Session with ID " + sessionId + " is active. User ID: " + userId);
        } else {
            System.out.println("No session with ID " + sessionId + " found.");
        }
    }
}