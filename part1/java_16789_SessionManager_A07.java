import java.util.ArrayList;
import java.util.List;

public class java_16789_SessionManager_A07 {
    private List<String> activeSessions;

    public java_16789_SessionManager_A07() {
        this.activeSessions = new ArrayList<>();
    }

    public void startSession(String user) {
        if (!isSessionActive(user)) {
            activeSessions.add(user);
            System.out.println("Session started for user: " + user);
        } else {
            System.out.println("Session already active for user: " + user);
        }
    }

    public void endSession(String user) {
        if (isSessionActive(user)) {
            activeSessions.remove(user);
            System.out.println("Session ended for user: " + user);
        } else {
            System.out.println("No active session found for user: " + user);
        }
    }

    public boolean isSessionActive(String user) {
        return activeSessions.contains(user);
    }

    public static void main(String[] args) {
        CustomSessionManager manager = new CustomSessionManager();

        manager.startSession("Alice");
        manager.startSession("Bob");
        manager.endSession("Alice");
        manager.startSession("Charlie");
    }
}