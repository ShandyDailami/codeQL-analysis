import java.util.HashMap;

public class java_06346_SessionManager_A03 {

    private HashMap<String, String> sessionMap;

    public java_06346_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis(); // for unique id, you can use UUID or similar
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String sessionId = sm.createSession("user1");
        System.out.println("Session ID: " + sessionId);
        String userId = sm.getUserId(sessionId);
        System.out.println("User ID: " + userId);
        sm.removeSession(sessionId);
    }
}