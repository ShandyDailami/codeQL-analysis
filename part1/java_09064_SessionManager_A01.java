import java.util.HashMap;
import java.util.Map;

public class java_09064_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_09064_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = UUID.randomUUID().toString();
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