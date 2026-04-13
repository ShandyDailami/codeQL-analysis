import java.util.HashMap;
import java.util.Map;

public class java_07387_SessionManager_A08 {

    private Map<String, String> sessions;

    public java_07387_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.createSession("session1", "user1");
        System.out.println(manager.getUserFromSession("session1")); // should print user1

        manager.createSession("session2", "user2");
        System.out.println(manager.getUserFromSession("session2")); // should print user2

        manager.deleteSession("session1");
        System.out.println(manager.getUserFromSession("session1")); // should print null

        System.out.println(manager.isValidSession("session2")); // should print true
        System.out.println(manager.isValidSession("session3")); // should print false
    }
}