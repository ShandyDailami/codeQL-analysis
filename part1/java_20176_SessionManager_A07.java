import java.util.HashMap;

public class java_20176_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_20176_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserFromSession(String sessionID) {
        return sessionMap.getOrDefault(sessionID, null);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}