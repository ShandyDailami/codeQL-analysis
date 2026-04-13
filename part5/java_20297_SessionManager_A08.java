import java.util.ArrayList;
import java.util.List;

public class java_20297_SessionManager_A08 {

    private List<String> activeSessions;

    public java_20297_SessionManager_A08() {
        activeSessions = new ArrayList<>();
    }

    public void startSession(String user) {
        activeSessions.add(user);
    }

    public void stopSession(String user) throws SecurityFailureException {
        if (!activeSessions.contains(user)) {
            throw new SecurityFailureException("Unable to stop session for user " + user + ". User not found.");
        }
        activeSessions.remove(user);
    }

    public List<String> getActiveSessions() {
        return activeSessions;
    }

    public static class SecurityFailureException extends Exception {
        public java_20297_SessionManager_A08(String message) {
            super(message);
        }
    }
}