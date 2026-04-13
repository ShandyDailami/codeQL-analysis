// Start of code

import java.util.HashMap;
import java.util.Map;

public class java_17712_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_17712_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        sessionMap.replace(sessionId, newSessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
// End of code