import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_21503_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21503_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new InvalidParameterException("User ID cannot be null or empty");
        }

        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new InvalidParameterException("Session ID cannot be null or empty");
        }

        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new InvalidParameterException("Session ID cannot be null or empty");
        }

        sessionMap.remove(sessionId);
    }
}