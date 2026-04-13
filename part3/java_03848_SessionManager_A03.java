import java.util.HashMap;
import java.util.Map;

public class java_03848_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_03848_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists");
        } else {
            System.out.println("Session started with ID: " + sessionId);
            sessionMap.put(sessionId, "Active");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId);
        } else {
            System.out.println("Session not found");
        }
    }

    public void checkSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID: " + sessionId + " is active");
        } else {
            System.out.println("Session with ID: " + sessionId + " not found");
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession("session1");
        sm.startSession("session2");
        sm.endSession("session1");
        sm.checkSession("session2");
    }
}