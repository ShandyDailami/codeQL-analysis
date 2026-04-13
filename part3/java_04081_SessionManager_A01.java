import java.util.HashMap;

public class java_04081_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_04081_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session " + sessionId + " started for user " + userId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            System.out.println("Session " + sessionId + " ended for user " + userId);
        } else {
            System.out.println("No session found for " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("123", "User1");
        sessionManager.endSession("123");
        sessionManager.startSession("456", "User2");
        sessionManager.endSession("456");
    }
}