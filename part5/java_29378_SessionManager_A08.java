import java.util.HashMap;
import java.util.Map;

public class java_29378_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_29378_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId1 = "session1";
        String userId1 = "user1";
        sessionManager.createSession(sessionId1, userId1);

        String sessionId2 = "session2";
        String userId2 = "user2";
        sessionManager.createSession(sessionId2, userId2);

        // Attempt to access the userId of a session that does not exist
        System.out.println(sessionManager.getUserId("nonExistentSession"));

        // Access userId of an existing session
        System.out.println(sessionManager.getUserId(sessionId1));
        System.out.println(sessionManager.getUserId(sessionId2));

        // Deleting a session
        sessionManager.deleteSession(sessionId1);

        // Attempt to access the userId of a deleted session
        System.out.println(sessionManager.getUserId("deletedSession"));
    }
}