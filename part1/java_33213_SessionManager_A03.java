import java.util.HashMap;
import java.util.Map;

public class java_33213_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_33213_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userName, String sessionId) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}