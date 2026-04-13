import java.util.ArrayList;
import java.util.List;

public class java_36434_SessionManager_A03 {
    private List<String> activeSessions;

    public java_36434_SessionManager_A03() {
        activeSessions = new ArrayList<>();
    }

    public void startSession(String sessionId) throws Exception {
        if (activeSessions.contains(sessionId)) {
            throw new Exception("Session already started with id: " + sessionId);
        }
        activeSessions.add(sessionId);
    }

    public void endSession(String sessionId) throws Exception {
        if (!activeSessions.contains(sessionId)) {
            throw new Exception("Session not started with id: " + sessionId);
        }
        activeSessions.remove(sessionId);
    }

    public String getSessionId() {
        if (activeSessions.isEmpty()) {
            throw new IllegalStateException("No session currently active");
        }
        return activeSessions.get(activeSessions.size() - 1);
    }
}