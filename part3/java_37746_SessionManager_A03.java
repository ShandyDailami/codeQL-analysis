import java.util.HashMap;
import java.util.Map;

public class java_37746_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_37746_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis(); // Creating a session using user ID and current time
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserFromSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void removeSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}