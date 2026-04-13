import java.util.HashMap;

public class java_40471_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_40471_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Cannot create new session.");
        } else {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No such session exists.");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No such session exists.");
        }
    }
}