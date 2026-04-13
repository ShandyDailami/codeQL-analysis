import java.util.HashMap;
import java.util.Map;

public class java_06782_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_06782_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started with id: " + sessionId + " for user: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with id: " + sessionId + " for user: " + userId);
        } else {
            System.out.println("Session does not exists with id: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.startSession("sess1", "user1");
        sm.startSession("sess2", "user2");
        sm.startSession("sess1", "user3"); // Attempt to start a session with an existing session id

        sm.endSession("sess1");
        sm.endSession("sess4"); // Attempt to end a session with a non-existing session id

        sm.startSession("sess3", "user3");
        sm.startSession("sess3", "user4");
    }
}