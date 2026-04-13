import java.util.HashMap;

public class java_17092_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_17092_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId) {
        this.sessionMap.put(sessionId, sessionId);
    }

    public void deleteSession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return this.sessionMap.containsKey(sessionId);
    }
}