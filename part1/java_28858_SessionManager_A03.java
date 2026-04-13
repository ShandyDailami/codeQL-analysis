import java.util.HashMap;
import java.util.Map;

public class java_28858_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_28858_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session created: " + sessionId + " for user: " + userId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session does not exist");
            return null;
        }
    }

    public void invalidateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session invalidated: " + sessionId);
        } else {
            System.out.println("Session does not exist");
        }
    }
}