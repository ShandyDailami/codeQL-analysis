import java.util.HashMap;
import java.util.Map;

public class java_08143_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_08143_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
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

    public void checkSessionIntegrity() {
        // This method can be used to check the integrity of the sessionMap
        // For this example, we'll just print the contents of the map
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            System.out.println("Session ID: " + entry.getKey() + ", Session Data: " + entry.getValue());
        }
    }
}