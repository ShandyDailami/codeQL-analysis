import java.util.HashMap;
import java.util.Map;

public class java_26834_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_26834_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSession(String sessionId) {
        String sessionData = sessionMap.get(sessionId);
        if (sessionData == null) {
            System.out.println("Invalid session ID: " + sessionId);
        }
        return sessionData;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}