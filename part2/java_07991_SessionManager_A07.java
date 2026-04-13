import java.util.HashMap;
import java.util.Map;

public class java_07991_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_07991_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addSession("session1", "user1");
        sessionManager.addSession("session2", "user2");

        if (sessionManager.hasSession("session1")) {
            System.out.println("User1 is in session1: " + sessionManager.getUserId("session1"));
        }

        if (sessionManager.hasSession("session2")) {
            System.out.println("User2 is in session2: " + sessionManager.getUserId("session2"));
        }

        sessionManager.removeSession("session1");
        sessionManager.removeSession("session2");

        if (!sessionManager.hasSession("session1")) {
            System.out.println("No session1 present");
        }

        if (!sessionManager.hasSession("session2")) {
            System.out.println("No session2 present");
        }
    }
}