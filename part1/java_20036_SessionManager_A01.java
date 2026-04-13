import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.Map;

public class java_20036_SessionManager_A01 {

    private Map<String, Subject> sessionMap;

    public java_20036_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Subject subject) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, subject);
        return sessionId;
    }

    public Subject getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // TODO: Implement a secure method to generate a session ID.
        // For now, let's generate a random session ID.
        return String.valueOf(System.currentTimeMillis());
    }
}