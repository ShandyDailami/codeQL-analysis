import javax.security.auth.login.FailedLoginException;
import java.util.HashMap;
import java.util.Map;

public class java_12408_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private Map<String, String> validationMap;

    public java_12408_SessionManager_A07() {
        sessionMap = new HashMap<>();
        validationMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String validateSession(String sessionId) throws FailedLoginException {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            if (validateUser(username)) {
                return username;
            } else {
                throw new FailedLoginException("User not authenticated");
            }
        } else {
            throw new FailedLoginException("Session not found");
        }
    }

    private String generateSessionId() {
        return UUID.randomUUID().toString(); // You can use UUID for session id generation
    }

    private boolean validateUser(String username) {
        // You can use your own authentication logic here.
        // For the sake of this example, we'll just check if the username is valid.
        return username != null && !username.isEmpty();
    }
}