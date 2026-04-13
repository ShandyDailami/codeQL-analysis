import java.util.HashMap;

public class java_00568_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_00568_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        // create a unique session ID for each user
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        // retrieve username from session ID
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // delete session from session ID
        sessionMap.remove(sessionId);
    }
}