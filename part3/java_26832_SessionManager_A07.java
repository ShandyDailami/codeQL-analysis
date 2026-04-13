import java.util.HashMap;
import java.util.Map;

public class java_26832_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26832_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId) {
        sessionMap.put(userId, userId);
    }

    public String getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            // Authentication failed
            throw new AuthFailureException();
        }
    }

    public void removeSession(String userId) {
        sessionMap.remove(userId);
    }
}