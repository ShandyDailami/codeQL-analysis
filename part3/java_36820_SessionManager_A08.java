import java.util.HashMap;
import java.util.Map;

public class java_36820_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_36820_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = UUID.randomUUID().toString(); // generate a unique ID for session
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