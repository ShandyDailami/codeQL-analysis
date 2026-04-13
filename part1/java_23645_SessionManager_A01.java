import java.util.HashMap;
import java.util.Map;

public class java_23645_SessionManager_A01 {

    private Map<String, String> sessions;

    public java_23645_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String userName, String password) {
        if (isPasswordWeak(password)) {
            throw new SecurityException("Weak password detected. Access denied.");
        }
        String sessionId = userName + System.currentTimeMillis();
        sessions.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private boolean isPasswordWeak(String password) {
        return password.length() < 8;
    }
}