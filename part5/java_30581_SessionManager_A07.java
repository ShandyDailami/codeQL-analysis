import java.util.HashMap;

public class java_30581_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_30581_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userID, String sessionID) {
        sessionMap.put(userID, sessionID);
    }

    public String getSession(String userID) {
        if (sessionMap.containsKey(userID)) {
            return sessionMap.get(userID);
        } else {
            return null;
        }
    }

    public void deleteSession(String userID) {
        if (sessionMap.containsKey(userID)) {
            sessionMap.remove(userID);
        }
    }

    public boolean isSessionValid(String userID, String sessionID) {
        if (sessionMap.containsKey(userID)) {
            return sessionMap.get(userID).equals(sessionID);
        } else {
            return false;
        }
    }
}