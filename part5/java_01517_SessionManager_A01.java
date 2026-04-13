import java.util.ArrayList;
import java.util.List;

public class java_01517_SessionManager_A01 {

    private List<String> activeSessions;

    public java_01517_SessionManager_A01() {
        activeSessions = new ArrayList<>();
    }

    public void startSession(String sessionId) {
        if (!isSessionActive(sessionId)) {
            activeSessions.add(sessionId);
            System.out.println("Session started: " + sessionId);
        } else {
            System.out.println("Session already active: " + sessionId);
        }
    }

    public void stopSession(String sessionId) {
        if (isSessionActive(sessionId)) {
            activeSessions.remove(sessionId);
            System.out.println("Session stopped: " + sessionId);
        } else {
            System.out.println("Session not active: " + sessionId);
        }
    }

    private boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }
}