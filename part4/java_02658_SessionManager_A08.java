import java.util.HashMap;

public class java_02658_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_02658_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionID) {
        sessionMap.put(sessionID, sessionID);
    }

    public String getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public boolean isSessionValid(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }
}