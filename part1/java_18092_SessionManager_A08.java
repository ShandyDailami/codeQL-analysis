import java.util.HashMap;

public class java_18092_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_18092_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Starting Session for User: " + userName);
            System.out.println("Existing session: " + sessionMap.get(sessionId));
        } else {
            System.out.println("Starting Session for User: " + userName);
            sessionMap.put(sessionId, userName);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            System.out.println("Ending Session for User: " + userName);
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No active session found for sessionId: " + sessionId);
        }
    }

    public void checkSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            System.out.println("Active session found for User: " + userName);
        } else {
            System.out.println("No active session found for sessionId: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("session1", "User1");
        sessionManager.startSession("session2", "User2");
        sessionManager.checkSession("session1");
        sessionManager.checkSession("session3");
        sessionManager.endSession("session1");
        sessionManager.checkSession("session1");
    }
}