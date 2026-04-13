import java.util.ArrayList;
import java.util.List;

public class java_20550_SessionManager_A01 {

    private List<String> activeSessions;

    public java_20550_SessionManager_A01() {
        activeSessions = new ArrayList<>();
    }

    public void startSession(String username) {
        activeSessions.add(username);
        System.out.println("Session started for user: " + username);
    }

    public void endSession(String username) throws BrokenAccessControlException {
        if (!activeSessions.contains(username)) {
            throw new BrokenAccessControlException("Attempted to end non-existing session.");
        }
        activeSessions.remove(username);
        System.out.println("Session ended for user: " + username);
    }

    public List<String> getActiveSessions() {
        return activeSessions;
    }

    // Define a custom exception class for BrokenAccessControlException
    public class BrokenAccessControlException extends Exception {
        public java_20550_SessionManager_A01(String message) {
            super(message);
        }
    }
}