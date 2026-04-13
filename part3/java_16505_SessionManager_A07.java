import java.util.HashMap;
import java.util.Map;

public class java_16505_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16505_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isValidCredentials(username, password)) {
            String sessionId = createSessionId();
            sessionMap.put(sessionId, username);
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Invalid credentials, session not started");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("Invalid session, nothing to end");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Here, we would normally use a real authentication service
        // to validate the username and password. For the sake of this example,
        // we will just return true if the username is "admin" and the password is "password".
        return "admin".equals(username) && "password".equals(password);
    }

    private String createSessionId() {
        // Here, we would normally generate a unique session ID. For the sake of this example,
        // we will just return a random session ID.
        return String.valueOf(System.currentTimeMillis());
    }
}