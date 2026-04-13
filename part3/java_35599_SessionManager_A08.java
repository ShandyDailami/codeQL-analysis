import java.util.HashMap;
import java.util.Map;

public class java_35599_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_35599_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session " + sessionId + " already exists.");
            return null;
        } else {
            sessionMap.put(sessionId, sessionId);
            return sessionId;
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session " + sessionId + " does not exist.");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session " + sessionId + " deleted successfully.");
        } else {
            System.out.println("Session " + sessionId + " does not exist.");
        }
    }
}