import java.util.HashMap;
import java.util.Map;

public class java_32382_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_32382_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = "session1";

        sessionManager.addSession(sessionId, userId);

        System.out.println("User ID of session " + sessionId + ": " + sessionManager.getUserId(sessionId));

        sessionManager.removeSession(sessionId);

        System.out.println("User ID of session " + sessionId + ": " + sessionManager.getUserId(sessionId));
    }
}