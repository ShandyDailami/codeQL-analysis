import java.util.HashMap;

public class java_05724_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_05724_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.addSession("session1", "user1");
        System.out.println("User1: " + sessionManager.getUserId("session1"));

        sessionManager.addSession("session2", "user2");
        System.out.println("User2: " + sessionManager.getUserId("session2"));

        sessionManager.removeSession("session1");
        System.out.println("After remove session1, User1: " + sessionManager.getUserId("session1"));
    }
}