import java.util.*;

public class java_02022_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_02022_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session Already Started with Id: " + sessionId);
        } else {
            sessions.put(sessionId, userId);
            System.out.println("Session Started with Id: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            System.out.println("Session Ended with Id: " + sessionId);
        } else {
            System.out.println("No Session with Id: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            System.out.println("No Session with Id: " + sessionId);
            return null;
        }
    }

    public boolean isSessionActive(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}