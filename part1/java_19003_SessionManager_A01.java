import java.util.HashMap;
import java.util.Map;

public class java_19003_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19003_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
            System.out.println("Started session with ID: " + sessionId);
        } else {
            System.out.println("Session already exists with ID: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session with ID: " + sessionId);
        } else {
            System.out.println("No session exists with ID: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session exists with ID: " + sessionId);
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");

        System.out.println(sessionManager.getUserId("session1")); // should print user1
        System.out.println(sessionManager.getUserId("session2")); // should print user2

        sessionManager.endSession("session1");

        System.out.println(sessionManager.getUserId("session1")); // should print null
    }
}