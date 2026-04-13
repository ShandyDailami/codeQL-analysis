import java.util.HashMap;
import java.util.Map;

public class java_37507_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_37507_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, userId);
    }

    public String getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            throw new SecurityFailureException("Unauthorized access: Session not found for user " + userId);
        }
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }
}