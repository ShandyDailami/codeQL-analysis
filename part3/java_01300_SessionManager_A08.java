import java.util.HashMap;

public class java_01300_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_01300_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + "_" + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void removeSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}