import java.util.HashMap;
import java.util.Map;

public class java_12446_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_12446_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void addSession(String username, String password) {
        if (password.length() >= 8) {
            sessions.put(username, password);
        } else {
            System.out.println("Password is too short. It must be at least 8 characters long.");
        }
    }

    public String getPassword(String username) {
        return sessions.get(username);
    }

    public void removeSession(String username) {
        sessions.remove(username);
    }

    public boolean isValidSession(String username, String password) {
        if (sessions.containsKey(username)) {
            return sessions.get(username).equals(password);
        } else {
            System.out.println("Invalid session. No session found for user: " + username);
            return false;
        }
    }
}