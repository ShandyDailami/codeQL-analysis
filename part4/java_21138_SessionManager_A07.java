import java.util.HashMap;
import java.util.Map;

public class java_21138_SessionManager_A07 implements SessionManagerInterface {
    private Map<String, String> sessionMap;

    public java_21138_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    @Override
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    @Override
    public void updateSession(String sessionId, String sessionValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionValue);
        }
    }

    @Override
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}