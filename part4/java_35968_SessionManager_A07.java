import java.util.HashMap;
import java.util.Map;

public class java_35968_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_35968_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        if (isValid(username, password)) {
            String sessionId = UUID.randomUUID().toString();
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            return null;
        }
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private boolean isValid(String username, String password) {
        // This is a placeholder for actual authentication logic.
        // For the sake of simplicity, we're just checking if the username is "admin" and the password is "password".
        // In a real application, you would want to use a more secure and complex method for authentication.
        return username.equals("admin") && password.equals("password");
    }
}