import java.util.HashMap;
import java.util.Map;

public class java_04066_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_04066_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Session ID: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Started session. Session ID: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session. Session ID: " + sessionId);
        } else {
            System.out.println("No session exists with this ID. Session ID: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a session
        sessionManager.startSession("A123", "User1");
        sessionManager.startSession("A123", "User2");

        // End a session
        sessionManager.endSession("A123");
        sessionManager.endSession("A124");
    }
}