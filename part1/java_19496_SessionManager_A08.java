import java.util.HashMap;

public class java_19496_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_19496_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void checkSessionIntegrity(String sessionId) {
        if (!isSessionActive(sessionId)) {
            System.out.println("Session with id " + sessionId + " does not exist.");
        } else {
            System.out.println("Session with id " + sessionId + " is active.");
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.startSession("session1", "user1");
        sm.checkSessionIntegrity("session1");

        String userId = sm.getUserId("session1");
        System.out.println("User id: " + userId);

        sm.checkSessionIntegrity("session2");

        sm.endSession("session1");
        sm.checkSessionIntegrity("session1");
    }
}