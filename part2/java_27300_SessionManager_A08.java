import java.util.HashMap;

public class java_27300_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_27300_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("A session with ID: " + sessionId + ", already exists.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("A session with ID: " + sessionId + ", has been started by user: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session with ID: " + sessionId + ", ended by user: " + userId);
        } else {
            System.out.println("No session with ID: " + sessionId + ", found to end.");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("s1", "u1");
        sessionManager.startSession("s2", "u2");
        sessionManager.startSession("s1", "u3"); // This will be ignored as 's1' already exists
        sessionManager.endSession("s1");
        sessionManager.endSession("s4"); // This will be ignored as 's4' does not exist
    }
}