import java.util.HashMap;

public class java_20927_SessionManager_A03 {
    private HashMap<String, Object> sessionMap;

    public java_20927_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionID, Object sessionObject) {
        sessionMap.put(sessionID, sessionObject);
    }

    public Object getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}