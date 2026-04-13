import java.util.HashMap;

public class java_33268_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_33268_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String data) {
        sessionMap.put(sessionId, data);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}