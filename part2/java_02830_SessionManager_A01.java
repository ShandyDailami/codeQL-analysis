import java.util.HashMap;

public class java_02830_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_02830_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Session creation
    public String createSession(String userID) {
        String sessionID = UUID.randomUUID().toString();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Session retrieval
    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Session invalidation (Broken Access Control)
    public void invalidateSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}