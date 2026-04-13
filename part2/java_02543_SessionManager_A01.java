import java.util.HashMap;
import java.util.Map;

public class java_02543_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_02543_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists!");
        } else {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found!");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No session found!");
        }
    }
}