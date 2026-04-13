import java.util.HashMap;
import java.util.Map;

public class java_03475_SessionManager_A08 {

    private static SessionManager instance;
    private Map<String, String> sessionMap;

    private java_03475_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}