import java.util.HashMap;

public class java_03719_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_03719_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionID, String userID) {
        sessionMap.put(sessionID, userID);
    }

    public String getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}