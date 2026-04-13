import java.util.HashMap;

public class java_15738_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_15738_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Please login first.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session created successfully.");
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Invalid session.");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session deleted successfully.");
        } else {
            System.out.println("Invalid session.");
        }
    }
}