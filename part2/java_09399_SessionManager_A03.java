import java.util.HashMap;

public class java_09399_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_09399_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}