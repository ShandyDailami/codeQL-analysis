import java.util.HashMap;
import java.util.Map;

public class java_04205_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_04205_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
        } else {
            System.out.println("No such session to update");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No such session to delete");
        }
    }
}