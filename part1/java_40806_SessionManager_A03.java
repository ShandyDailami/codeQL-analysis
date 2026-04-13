import java.util.HashMap;
import java.util.Map;

public class java_40806_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_40806_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void updateSession(String sessionId, String newSessionData) {
        sessionMap.replace(sessionId, newSessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}