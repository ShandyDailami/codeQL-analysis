import java.util.HashMap;

public class java_03564_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_03564_SessionManager_A08() {
        sessionMap = new HashMap<String, String>();
    }

    public String createSession(String user) {
        String sessionId = "" + System.currentTime() + user;
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}