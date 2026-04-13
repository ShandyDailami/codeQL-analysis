import java.util.HashMap;
import java.util.Map;

public class java_35789_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_35789_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.addSession("session1", "user1");
        sessionManager.addSession("session2", "user2");

        if (sessionManager.isValidSession("session1")) {
            System.out.println("User: " + sessionManager.getUserName("session1"));
        }

        sessionManager.removeSession("session1");

        if (!sessionManager.isValidSession("session1")) {
            System.out.println("Session is valid.");
        }
    }
}