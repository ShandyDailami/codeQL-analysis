import java.util.ArrayList;
import java.util.List;

public class java_12951_SessionManager_A01 {
    private List<String> activeSessions;

    public java_12951_SessionManager_A01() {
        activeSessions = new ArrayList<>();
    }

    public void startSession(String sessionId) {
        activeSessions.add(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public void endSession(String sessionId) {
        activeSessions.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a session
        sessionManager.startSession("session1");

        // Check if the session is active
        if (sessionManager.isSessionActive("session1")) {
            System.out.println("Session is active");
        } else {
            System.out.println("Session is not active");
        }

        // End a session
        sessionManager.endSession("session1");

        // Check if the session is active after end
        if (!sessionManager.isSessionActive("session1")) {
            System.out.println("Session is now inactive");
        } else {
            System.out.println("Session is active");
        }
    }
}