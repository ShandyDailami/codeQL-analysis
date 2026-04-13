import java.util.HashMap;

public class java_22474_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_22474_SessionManager_A08() {
        sessionMap = new HashMap<String, String>();
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