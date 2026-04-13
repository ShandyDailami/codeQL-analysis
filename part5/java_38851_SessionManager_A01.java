import java.util.HashMap;

public class java_38851_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_38851_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session not found");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}