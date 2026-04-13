import java.util.HashMap;
import java.util.Map;

public class java_24405_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_24405_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void breakAccess(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Access violation detected in session: " + sessionId);
            deleteSession(sessionId);
        } else {
            System.out.println("No access violation detected in session: " + sessionId);
        }
    }
}