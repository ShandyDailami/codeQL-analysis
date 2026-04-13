import java.util.HashMap;
import java.util.Map;

public class java_07690_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_07690_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session ID already exists. Unable to create a new session.");
            return;
        }
        sessionMap.put(sessionId, userId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session ID does not exist. Unable to delete a session.");
            return;
        }
        sessionMap.remove(sessionId);
    }

    public String getUserFromSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session ID does not exist.");
            return null;
        }
        return sessionMap.get(sessionId);
    }
}