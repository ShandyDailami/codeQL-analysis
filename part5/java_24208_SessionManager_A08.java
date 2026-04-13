import java.util.HashMap;

public class java_24208_SessionManager_A08 {

    private HashMap<String, String> sessionMap;

    public java_24208_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}