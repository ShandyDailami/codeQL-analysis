import java.util.HashMap;
import java.util.Map;

public class java_20604_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_20604_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userName) {
        // Hash the session id to enhance security
        String hashedSessionId = hashSessionId(sessionId);
        sessionMap.put(hashedSessionId, userName);
        return hashedSessionId;
    }

    public String getUserNameBySessionId(String sessionId) {
        // Hash the session id to enhance security
        String hashedSessionId = hashSessionId(sessionId);
        return sessionMap.get(hashedSessionId);
    }

    private String hashSessionId(String sessionId) {
        // You can implement your own session id hashing mechanism
        // For the sake of simplicity, we just hash the session id
        return String.valueOf(sessionId.hashCode());
    }
}