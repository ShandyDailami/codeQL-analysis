import java.util.HashMap;

public class java_22935_SessionManager_A01 {

    private HashMap<String, String> sessionMap;

    public java_22935_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionID, username);
        return sessionID;
    }

    public String getUsername(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void removeSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}