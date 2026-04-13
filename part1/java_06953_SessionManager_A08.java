import java.util.HashMap;
import java.util.Map;

public class java_06953_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_06953_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Invalid session ID!");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Invalid session ID!");
        }
    }
}