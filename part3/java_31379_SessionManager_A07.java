import java.util.HashSet;
import java.util.Set;

public class java_31379_SessionManager_A07 {
    private Set<String> activeSessions;

    public java_31379_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public void startSession(String user) {
        activeSessions.add(user);
    }

    public void endSession(String user) {
        activeSessions.remove(user);
    }

    public boolean isSessionActive(String user) {
        return activeSessions.contains(user);
    }

    public int getActiveSessionCount() {
        return activeSessions.size();
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Start Session
        manager.startSession("User1");

        // Check if session is active
        System.out.println("Session is active: " + manager.isSessionActive("User1"));

        // End Session
        manager.endSession("User1");

        // Check if session is still active
        System.out.println("Session is active: " + manager.isSessionActive("User1"));

        // Check the count of active sessions
        System.out.println("Active sessions: " + manager.getActiveSessionCount());
    }
}