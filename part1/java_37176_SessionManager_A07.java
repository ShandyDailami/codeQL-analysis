import java.util.HashMap;
import java.util.Map;

public class java_37176_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private Map<String, String> usernameMap;

    public java_37176_SessionManager_A07() {
        sessionMap = new HashMap<>();
        usernameMap = new HashMap<>();
    }

    public void startSession(String sessionID, String username) {
        sessionMap.put(sessionID, "Active");
        usernameMap.put(sessionID, username);
    }

    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
        usernameMap.remove(sessionID);
    }

    public String isSessionActive(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            if (sessionMap.get(sessionID).equals("Active")) {
                return "Active";
            }
        }
        return "Inactive";
    }

    public String getUsername(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return usernameMap.get(sessionID);
        }
        return null;
    }
}