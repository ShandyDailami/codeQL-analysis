import java.util.HashMap;
import java.util.Map;

public class java_32703_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_32703_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session already exists: " + sessionId);
        } else {
            sessions.put(sessionId, sessionId);
            System.out.println("Started session: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            System.out.println("Ended session: " + sessionId);
        } else {
            System.out.println("No session found: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1");
        sessionManager.startSession("session2");
        sessionManager.startSession("session3");

        sessionManager.endSession("session2");
        sessionManager.endSession("session4");
    }
}