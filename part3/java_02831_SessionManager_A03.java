import java.util.HashMap;

public class java_02831_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_02831_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}