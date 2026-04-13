import java.util.HashMap;

public class java_27741_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_27741_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session " + sessionId + " does not exist.");
        }
    }
}