import java.util.HashMap;

public class java_41475_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_41475_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
        System.out.println("Session started with ID: " + sessionId + " and username: " + username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Session ended with ID: " + sessionId);
    }
}