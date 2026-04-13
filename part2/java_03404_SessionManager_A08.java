import java.util.HashMap;
import java.util.Map;

public class java_03404_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_03404_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session with id " + sessionId + " created for user " + userId + ".");
        }
    }

    public void getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("Session with id " + sessionId + " belongs to user " + userId + ".");
        } else {
            System.out.println("Session with id " + sessionId + " does not exist.");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session with id " + sessionId + " deleted for user " + userId + ".");
        } else {
            System.out.println("Session with id " + sessionId + " does not exist.");
        }
    }

    public static void main(String[] args) {
        LegacySessionManager sessionManager = new LegacySessionManager();

        sessionManager.createSession("session1", "user1");
        sessionManager.createSession("session2", "user2");
        sessionManager.createSession("session3", "user3");

        sessionManager.getSession("session1");
        sessionManager.getSession("session2");
        sessionManager.getSession("session3");

        sessionManager.deleteSession("session1");

        sessionManager.getSession("session1");
    }
}