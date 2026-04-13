import java.util.HashMap;
import java.util.Map;

public class java_38152_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_38152_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            return "A08_IntegrityFailure: Session already exists for user";
        } else {
            sessionMap.put(userId, sessionId);
            return "Session created successfully";
        }
    }

    public String getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return "A08_IntegrityFailure: User not found";
        }
    }

    public String removeSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
            return "Session removed successfully";
        } else {
            return "A08_IntegrityFailure: User not found";
        }
    }

    public String updateSession(String userId, String newSessionId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.replace(userId, sessionMap.get(userId), newSessionId);
            return "Session updated successfully";
        } else {
            return "A08_IntegrityFailure: User not found";
        }
    }
}