import java.util.HashMap;
import java.util.Map;

public class java_28401_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_28401_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple way of generating a session id. In a real-world scenario, you'd probably want to use a UUID here.
        // This is also not a secure way of generating a session id, as it's impossible to predict the content of a session id.
        // It's okay to use this for educational purposes.
        return String.valueOf(System.currentTimeMillis());
    }
}