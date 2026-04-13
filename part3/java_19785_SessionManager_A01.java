import java.util.HashMap;

public class java_19785_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_19785_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userName, String sessionId) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}