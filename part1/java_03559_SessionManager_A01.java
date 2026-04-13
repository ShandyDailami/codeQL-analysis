import java.util.ArrayList;
import java.util.List;

public class java_03559_SessionManager_A01 {
    private static List<String> activeSessions;

    public java_03559_SessionManager_A01() {
        activeSessions = new ArrayList<>();
    }

    public void openSession(String sessionId) {
        activeSessions.add(sessionId);
        System.out.println("Session " + sessionId + " opened.");
    }

    public void closeSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
            System.out.println("Session " + sessionId + " closed.");
        } else {
            System.out.println("No session " + sessionId + " is currently active.");
        }
    }

    public void checkAccess(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            System.out.println("Session " + sessionId + " is active.");
        } else {
            System.out.println("No session " + sessionId + " is currently active.");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.openSession("Session1");
        sessionManager.openSession("Session2");
        sessionManager.checkAccess("Session2");
        sessionManager.closeSession("Session1");
        sessionManager.checkAccess("Session1");
    }
}