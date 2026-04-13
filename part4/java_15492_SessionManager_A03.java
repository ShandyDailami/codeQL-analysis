import java.util.HashMap;
import java.util.Map;

public class java_15492_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_15492_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive operation: Inject data into session
    public void injectSessionData(String sessionId, String injectionData) {
        sessionMap.put(sessionId, injectionData);
    }

    // Security-sensitive operation: Get data from session
    public String getSessionDataFromDatabase(String sessionId) {
        return sessionMap.get(sessionId);
    }
}