import java.util.HashMap;
import java.util.Map;

public class java_25876_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_25876_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
        System.out.println("Session created with ID: " + sessionId);
    }

    public String getSessionValue(String sessionId) {
        String sessionValue = sessionMap.get(sessionId);
        if (sessionValue == null) {
            System.out.println("No session found with ID: " + sessionId);
            return null;
        }
        System.out.println("Session found with ID: " + sessionId + ", Value: " + sessionValue);
        return sessionValue;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Session deleted with ID: " + sessionId);
    }
}