import java.util.HashMap;
import java.util.Map;

public class java_24695_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_24695_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionID, String sessionData) {
        sessionMap.put(sessionID, sessionData);
        return sessionID;
    }

    public String getSessionData(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}