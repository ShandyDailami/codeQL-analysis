import java.util.HashMap;
import java.util.Map;

public class java_37500_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_37500_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists for the id " + sessionId);
        } else {
            sessionMap.put(sessionId, "Active");
            System.out.println("Session created for the id " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended for the id " + sessionId);
        } else {
            System.out.println("No session exists for the id " + sessionId);
        }
    }

    public void printSessions() {
        System.out.println("Active sessions: " + sessionMap);
    }
}