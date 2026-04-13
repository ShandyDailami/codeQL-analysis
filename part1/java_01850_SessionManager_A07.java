import java.util.HashMap;
import java.util.Map;

public class java_01850_SessionManager_A07 {

    private Map<String, String> sessionMap = new HashMap<>();
    private Map<String, String> authorizedUsers = new HashMap<>();

    public java_01850_SessionManager_A07() {
        // Initialize authorized users. You may call an authentication service to fill this map.
        authorizedUsers.put("user1", "password1");
        authorizedUsers.put("user2", "password2");
    }

    public String createSession(String username, String password) {
        if (isUserAuthorized(username, password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            throw new AuthFailureException();
        }
    }

    public void destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            // You may also log out the user here if needed.
        }
    }

    private boolean isUserAuthorized(String username, String password) {
        return authorizedUsers.get(username).equals(password);
    }

    private String generateSessionId() {
        return String.valueOf(System.nanoTime());
    }
}

class AuthFailureException extends RuntimeException {
    // This exception will be thrown if a user is not authorized.
}