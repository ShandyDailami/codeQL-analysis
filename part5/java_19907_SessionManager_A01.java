import java.util.ArrayList;
import java.util.List;

public class java_19907_SessionManager_A01 {
    private List<String> sessions = new ArrayList<>();

    public void startSession(String sessionId) {
        if (!sessions.contains(sessionId)) {
            sessions.add(sessionId);
        }
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessions.contains(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("Session1");
        sessionManager.startSession("Session2");

        // Broken access control.
        sessionManager.endSession("Session1");

        System.out.println("Session1 is active: " + sessionManager.isSessionActive("Session1"));
        System.out.println("Session2 is active: " + sessionManager.isSessionActive("Session2"));
    }
}