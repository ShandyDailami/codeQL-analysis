import java.util.HashMap;

public class java_02289_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_02289_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}