import java.util.HashMap;
import java.util.Map;

public class java_37597_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_37597_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method should generate a unique session id
        // In this example, we're just generating a random string
        return String.valueOf((int) (Math.random() * 100000));
    }
}