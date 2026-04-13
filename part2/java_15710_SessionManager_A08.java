import java.util.HashMap;

public class java_15710_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_15710_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}