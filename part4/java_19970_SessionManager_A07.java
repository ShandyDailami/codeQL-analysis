import java.util.HashMap;
import java.util.Map;

public class java_19970_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_19970_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Authentication failure due to invalid session: " + sessionId);
        } else {
            System.out.println("Session valid: " + sessionId);
        }
    }
}