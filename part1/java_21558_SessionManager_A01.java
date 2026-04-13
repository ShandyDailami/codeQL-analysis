import java.util.HashMap;

public class java_21558_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_21558_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started with ID: " + sessionId + ", User ID: " + userId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId + ", User ID: " + userId);
        } else {
            System.out.println("Session with ID: " + sessionId + " does not exist");
        }
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session with ID: " + sessionId + " does not exist");
            return null;
        }
    }
}