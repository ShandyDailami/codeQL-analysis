import java.util.HashMap;
import java.util.Map;

public class java_03226_SessionManager_A07 {
    private Map<String, String> sessions;
    private Map<String, String> credentials;

    public java_03226_SessionManager_A07() {
        sessions = new HashMap<>();
        credentials = new HashMap<>();
    }

    public void addUser(String username, String password) {
        credentials.put(username, password);
    }

    public String login(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            String sessionId = getSessionId();
            sessions.put(sessionId, username);
            return sessionId;
        } else {
            throw new AuthenticationFailureException();
        }
    }

    public String getSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }

    public String getUsername(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new InvalidSessionException();
        }
    }

    public void logout(String sessionId) {
        sessions.remove(sessionId);
    }
}

class AuthenticationFailureException extends RuntimeException {
    // Exception when authentication fails
}

class InvalidSessionException extends RuntimeException {
    // Exception when getting username from invalid session
}