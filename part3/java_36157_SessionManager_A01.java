import java.util.HashMap;
import java.util.Map;

public class java_36157_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_36157_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String username, String password) {
        if (isValidUser(username, password)) {
            sessions.put(username, password);
        } else {
            throw new BrokenAccessControlException();
        }
    }

    public String getSession(String username) {
        return sessions.get(username);
    }

    public void deleteSession(String username) {
        sessions.remove(username);
    }

    private boolean isValidUser(String username, String password) {
        // This is a dummy method for demonstration purposes.
        // In a real scenario, we should use a secure method to compare passwords.
        return true;
    }

    private class BrokenAccessControlException extends RuntimeException {
        // Exception to represent a broken access control violation.
    }
}