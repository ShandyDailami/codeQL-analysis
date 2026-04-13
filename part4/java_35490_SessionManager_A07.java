import java.util.HashMap;
import java.util.Map;

public class java_35490_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_35490_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void validateSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            System.out.println("Session validated for user: " + sessionMap.get(sessionID));
        } else {
            System.out.println("Invalid session");
        }
    }
}