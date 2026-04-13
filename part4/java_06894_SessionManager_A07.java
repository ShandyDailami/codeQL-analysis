import java.util.ArrayList;
import java.util.List;

public class java_06894_SessionManager_A07 {
    private List<String> activeSessions;

    public java_06894_SessionManager_A07() {
        this.activeSessions = new ArrayList<>();
    }

    public void startSession(String user) {
        if (!activeSessions.contains(user)) {
            activeSessions.add(user);
            System.out.println("Session started for user: " + user);
        } else {
            System.out.println("Session already started for user: " + user);
        }
    }

    public void endSession(String user) {
        if (activeSessions.contains(user)) {
            activeSessions.remove(user);
            System.out.println("Session ended for user: " + user);
        } else {
            System.out.println("No session started for user: " + user);
        }
    }

    public boolean isSessionActive(String user) {
        return activeSessions.contains(user);
    }
}