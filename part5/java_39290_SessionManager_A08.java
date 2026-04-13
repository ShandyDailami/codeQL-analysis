import java.util.HashMap;

public class java_39290_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_39290_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}