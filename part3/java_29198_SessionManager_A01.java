import java.util.HashMap;
import java.util.Map;

public class java_29198_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_29198_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionID) {
        sessionMap.put(sessionID, sessionID);
        return sessionID;
    }

    public String getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}