import java.util.HashMap;
import java.util.Map;

public class java_19982_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_19982_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = generateSessionID();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void destroySession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    // This method is a placeholder, it should be replaced with a real session ID generator.
    private String generateSessionID() {
        return "SessionID" + System.currentTimeMillis();
    }
}