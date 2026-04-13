import java.util.HashMap;
import java.util.Map;

public class java_16377_SessionManager_A01 {

    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_16377_SessionManager_A01() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        userMap.put(userID, sessionID);
        return sessionID;
    }

    public String getUser(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public boolean isValidSession(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    public boolean isValidUser(String userID) {
        return userMap.containsKey(userID);
    }

    public void destroySession(String sessionID) {
        String userID = sessionMap.get(sessionID);
        sessionMap.remove(sessionID);
        userMap.remove(userID);
    }

    public void destroyUser(String userID) {
        String sessionID = userMap.get(userID);
        userMap.remove(userID);
        sessionMap.remove(sessionID);
    }
}