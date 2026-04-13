import java.util.HashMap;
import java.util.Map;

public class java_00811_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_00811_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session created with id: " + sessionId);
        }
    }

    public void getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("Session exists with id: " + sessionId + ", user id: " + userId);
        } else {
            System.out.println("Session does not exist with id: " + sessionId);
        }
    }

    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.remove(sessionId);
            System.out.println("Session closed with id: " + sessionId + ", user id: " + userId);
        } else {
            System.out.println("Session does not exist with id: " + sessionId);
        }
    }
}