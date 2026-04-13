import java.util.HashMap;
import java.util.Map;

public class java_33808_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33808_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public void startSession(String sessionId, String userId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
        } else {
            System.out.println("Session already exists!");
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Session does not exist!");
        }
    }

    // Method to check the user in a session
    public void checkUserInSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("User ID in session: " + userId);
        } else {
            System.out.println("Session does not exist!");
        }
    }

    // Method to check if a session exists
    public void checkSessionExists(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session does not exist!");
        } else {
            System.out.println("Session exists!");
        }
    }
}