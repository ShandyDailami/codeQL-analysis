import java.util.ArrayList;
import java.util.List;

public class java_01397_SessionManager_A07 {
    private List<String> activeSessions;

    public java_01397_SessionManager_A07() {
        this.activeSessions = new ArrayList<>();
    }

    public void startSession(String username) {
        activeSessions.add(username);
    }

    public void endSession(String username) {
        if (activeSessions.contains(username)) {
            activeSessions.remove(username);
        } else {
            throw new SecurityFailureException("No active session found for username: " + username);
        }
    }

    public boolean hasActiveSession(String username) {
        return activeSessions.contains(username);
    }
}