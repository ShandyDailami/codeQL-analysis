import java.util.HashMap;
import java.util.Map;

public class java_13087_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_13087_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user, String password) {
        if (isValid(user, password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, user);
            return sessionId;
        }
        return null;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private boolean isValid(String user, String password) {
        // This is a simple validation check. In real use, you would need to use a more secure method to validate the user and password.
        return user != null && user.equals("admin") && password != null && password.equals("password");
    }

    private String generateSessionId() {
        // This is a simple session ID generation. In real use, you would need to use a more secure method to generate a unique session ID.
        return String.valueOf(System.currentTimeMillis());
    }
}