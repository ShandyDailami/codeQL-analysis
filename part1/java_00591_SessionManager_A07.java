import java.util.HashMap;
import java.util.Map;

public class java_00591_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00591_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionId) throws Exception {
        if (sessionMap.containsKey(sessionId)) {
            throw new Exception("Session already exists for the user: " + username);
        }
        sessionMap.put(sessionId, username);
    }

    public void endSession(String sessionId) throws Exception {
        if (!sessionMap.containsKey(sessionId)) {
            throw new Exception("No session exists for the provided sessionId: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public String getUserName(String sessionId) throws Exception {
        if (!sessionMap.containsKey(sessionId)) {
            throw new Exception("No session exists for the provided sessionId: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try {
            sessionManager.startSession("user1", "session1");
            System.out.println(sessionManager.getUserName("session1"));
            sessionManager.endSession("session1");

            sessionManager.startSession("user2", "session2");
            System.out.println(sessionManager.getUserName("session2"));
            sessionManager.endSession("session2");

            sessionManager.startSession("user1", "session3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}