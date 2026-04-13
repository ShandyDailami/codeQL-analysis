import java.util.HashMap;
import java.util.Map;

public class java_04731_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_04731_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // A03: Injecting sessionID to check if it is valid
    public boolean isValidSession(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    // A03: Injecting sessionID and data to save data in the session
    public void saveSessionData(String sessionID, String data) {
        sessionMap.put(sessionID, data);
    }

    // A03: Injecting sessionID to get data from the session
    public String getSessionData(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // A03: Injecting sessionID to delete data from the session
    public void deleteSessionData(String sessionID) {
        sessionMap.remove(sessionID);
    }
}