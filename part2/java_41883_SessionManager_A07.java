import java.util.HashMap;

public class java_41883_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_41883_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists!");
        } else {
            sessionMap.put(sessionId, userName);
            System.out.println("Session started with user: " + userName);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userName);
        } else {
            System.out.println("No session found!");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("session1", "User1");
        sessionManager.startSession("session2", "User2");
        sessionManager.endSession("session1");
        sessionManager.startSession("session3", "User3");
    }
}