import java.util.HashMap;
import java.util.Map;

public class java_16442_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16442_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = null;
        if (sessionMap.size() == 0) {
            sessionId = "S001";
        } else {
            int size = sessionMap.size();
            sessionId = "S" + (size + 1);
        }
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }
}