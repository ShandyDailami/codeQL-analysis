import java.util.HashMap;

public class java_32968_SessionManager_A08 {

    private HashMap<String, String> sessionMap;

    public java_32968_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
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

    public void deleteAllSessions() {
        sessionMap.clear();
    }
}