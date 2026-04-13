import java.util.HashMap;
import java.util.Map;

public class java_16537_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16537_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, "ACTIVE");
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSessionStatus(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "INACTIVE";
        }
    }

    public void authFailure(String sessionId) {
        String status = getSessionStatus(sessionId);
        if (status.equals("ACTIVE")) {
            endSession(sessionId);
            System.out.println("Authentication failure for session: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("session1");
        manager.startSession("session2");

        manager.authFailure("session1");
        manager.authFailure("session3");

        manager.endSession("session2");

        manager.authFailure("session2");
        manager.authFailure("session1");
    }
}