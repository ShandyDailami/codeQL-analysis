import java.util.HashMap;

public class java_06937_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_06937_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}