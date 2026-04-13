import java.util.HashMap;
import java.util.Map;

public class java_12334_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_12334_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
        System.out.println("Session Created: " + sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session Deleted: " + sessionId);
        } else {
            System.out.println("No session found for deletion: " + sessionId);
        }
    }

    public void updateSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, username);
            System.out.println("Session Updated: " + sessionId);
        } else {
            System.out.println("No session found for update: " + sessionId);
        }
    }

    public void getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Username in session: " + sessionMap.get(sessionId));
        } else {
            System.out.println("No session found: " + sessionId);
        }
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}