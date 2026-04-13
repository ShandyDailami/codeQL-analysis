import java.util.HashMap;

public class java_26937_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_26937_SessionManager_A01() {
        sessionMap = new HashMap<String, String>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}