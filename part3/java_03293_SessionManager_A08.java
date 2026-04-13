import java.util.HashSet;
import java.util.Set;

public class java_03293_SessionManager_A08 {
    private Set<String> activeSessions;

    public java_03293_SessionManager_A08() {
        this.activeSessions = new HashSet<>();
    }

    public void startSession(String sessionId) throws Exception {
        if (activeSessions.contains(sessionId)) {
            throw new Exception("Session already exists for this ID: " + sessionId);
        }

        activeSessions.add(sessionId);
        // add necessary code here to start the session
    }

    public void endSession(String sessionId) throws Exception {
        if (!activeSessions.contains(sessionId)) {
            throw new Exception("No active session found for this ID: " + sessionId);
        }

        activeSessions.remove(sessionId);
        // add necessary code here to end the session
    }

    public void checkSession(String sessionId) throws Exception {
        if (!activeSessions.contains(sessionId)) {
            throw new Exception("No active session found for this ID: " + sessionId);
        }

        // add necessary code here to check the session
    }

    public static void main(String[] args) {
        try {
            SessionManager sessionManager = new SessionManager();
            sessionManager.startSession("session1");
            sessionManager.startSession("session2");
            sessionManager.checkSession("session1");
            sessionManager.endSession("session2");
            sessionManager.checkSession("session2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}