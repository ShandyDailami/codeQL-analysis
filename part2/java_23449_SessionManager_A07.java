import java.util.HashMap;
import java.util.Map;

public class java_23449_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_23449_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = java.util.UUID.randomUUID().toString();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}