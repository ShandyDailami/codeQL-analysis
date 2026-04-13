import java.util.HashMap;
import java.util.Map;

public class java_21742_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_21742_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String username) {
        // Implement secure access control here to ensure only authorized users can start sessions.
        // For simplicity, let's assume that only admin users can start sessions.
        if ("admin".equals(username)) {
            sessions.put(username, "session");
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Access Denied for user: " + username);
        }
    }

    public void endSession(String username) {
        // Implement secure access control here to ensure only authorized users can end sessions.
        // For simplicity, let's assume that only admin users can end sessions.
        if ("admin".equals(username)) {
            String sessionId = sessions.get(username);
            if (sessionId != null) {
                sessions.remove(username);
                System.out.println("Session ended for user: " + username);
            } else {
                System.out.println("No session found for user: " + username);
            }
        } else {
            System.out.println("Access Denied for user: " + username);
        }
    }
}