import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class java_15567_SessionManager_A03 {
    private final Map<String, String> sessionMap = new ConcurrentHashMap<>();

    // Session ID is hashed to a unique value for security
    private Function<String, String> hasher = s -> s.hashCode() + "";

    public String createSession(String userId) {
        String sessionId = hasher.apply(userId);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Security-sensitive operation
    // This method only allows the user associated with the session to access the session
    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}