import java.util.HashMap;
import java.util.Map;

public class java_23257_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_23257_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session already exists. ID: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session created. ID: " + sessionId + ", User ID: " + userId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session deleted. ID: " + sessionId);
        } else {
            System.out.println("Error: Session does not exist. ID: " + sessionId);
        }
    }

    public void getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("Session found. ID: " + sessionId + ", User ID: " + userId);
        } else {
            System.out.println("Error: Session does not exist. ID: " + sessionId);
        }
    }

    public void updateSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, userId);
            System.out.println("Session updated. ID: " + sessionId + ", User ID: " + userId);
        } else {
            System.out.println("Error: Session does not exist. ID: " + sessionId);
        }
    }
}