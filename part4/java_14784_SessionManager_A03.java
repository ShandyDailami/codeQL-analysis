import java.util.HashMap;
import java.util.Map;

public class java_14784_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_14784_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String userID, String sessionID) {
        sessionMap.put(sessionID, userID);
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}