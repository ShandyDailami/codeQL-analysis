import java.util.HashSet;
import java.util.Set;

public class java_35124_SessionManager_A08 {

    private Set<String> activeSessions;

    public java_35124_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public void startSession(String sessionId) throws Exception {
        if (activeSessions.contains(sessionId)) {
            throw new Exception("Session already exists: " + sessionId);
        }
        activeSessions.add(sessionId);
    }

    public void endSession(String sessionId) throws Exception {
        if (!activeSessions.contains(sessionId)) {
            throw new Exception("Session does not exist: " + sessionId);
        }
        activeSessions.remove(sessionId);
    }

    public void checkIntegrity() {
        if (activeSessions.size() > 0) {
            System.out.println("Integrity check failed: active sessions: " + activeSessions);
        } else {
            System.out.println("Integrity check passed: no active sessions");
        }
    }

    public static void main(String[] args) {
        try {
            SessionManager manager = new SessionManager();
            manager.startSession("session1");
            manager.startSession("session2");
            manager.endSession("session1");
            manager.checkIntegrity();
            manager.endSession("session2");
            manager.checkIntegrity();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}