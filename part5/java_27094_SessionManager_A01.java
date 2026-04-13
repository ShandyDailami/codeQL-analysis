import java.util.HashMap;
import java.util.Map;

public class java_27094_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_27094_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}