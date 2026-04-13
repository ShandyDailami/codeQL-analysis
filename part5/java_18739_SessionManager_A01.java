import java.util.HashMap;
import java.util.Map;

public class java_18739_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_18739_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Replacing existing session.");
            sessionMap.replace(sessionId, userName);
        } else {
            System.out.println("Creating new session.");
            sessionMap.put(sessionId, userName);
        }
    }

    public String getUserNameFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Deleting session: " + sessionId);
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No session to delete.");
        }
    }
}