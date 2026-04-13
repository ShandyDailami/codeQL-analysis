import java.util.ArrayList;
import java.util.HashMap;

public class java_26873_SessionManager_A01 {
    private HashMap<String, String> sessionData;
    private ArrayList<String> activeSessions;
    private static final String SESSION_ID_PREFIX = "SID_";

    public java_26873_SessionManager_A01() {
        sessionData = new HashMap<>();
        activeSessions = new ArrayList<>();
    }

    public String createSession(String userID) {
        String sessionID = SESSION_ID_PREFIX + userID + System.currentTimeMillis();
        sessionData.put(sessionID, userID);
        activeSessions.add(sessionID);
        return sessionID;
    }

    public String getUserFromSession(String sessionID) {
        return sessionData.get(sessionID);
    }

    public void endSession(String sessionID) {
        sessionData.remove(sessionID);
        activeSessions.remove(sessionID);
    }

    public boolean isValidSession(String sessionID) {
        return activeSessions.contains(sessionID) && sessionData.containsKey(sessionID);
    }
}