import java.util.HashMap;

public class java_32329_SessionManager_A01 {

    private HashMap<String, String> sessionMap;

    public java_32329_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void setSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}