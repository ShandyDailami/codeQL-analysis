import java.util.HashMap;
import java.util.Map;

public class java_40110_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_40110_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userID, String sessionID) {
        sessionMap.put(sessionID, userID);
    }

    public String getUserFromSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void invalidateSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}