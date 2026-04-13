import java.util.HashMap;
import java.util.Map;

public class java_01714_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_01714_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found with the given sessionId");
            return null;
        }
    }

    public void updateSessionData(String sessionId, String newData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newData);
        } else {
            System.out.println("No session found with the given sessionId");
        }
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}