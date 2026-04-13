import java.util.HashMap;
import java.util.Map;

public class java_00652_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_00652_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isValidUser(String userId, String sessionId) {
        String storedSessionId = sessionMap.get(userId);
        return storedSessionId != null && storedSessionId.equals(sessionId);
    }

}