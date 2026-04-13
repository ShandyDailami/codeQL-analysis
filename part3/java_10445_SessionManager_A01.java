import java.util.HashMap;
import java.util.Map;

public class java_10445_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private Map<String, String> allowedUsers;

    public java_10445_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
        this.allowedUsers = new HashMap<>();
    }

    public void addAllowedUser(String username) {
        this.allowedUsers.put(username, username);
    }

    public String getSession(String username) {
        if (allowedUsers.containsKey(username)) {
            String sessionId = sessionMap.size() + "";
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            throw new IllegalArgumentException("Access denied for user: " + username);
        }
    }

    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.remove(sessionId);
            System.out.println("Session " + sessionId + " is removed for user: " + username);
        } else {
            System.out.println("Session not found");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.addAllowedUser("user1");
        manager.addAllowedUser("user2");
        manager.addAllowedUser("user3");

        String session1 = manager.getSession("user1");
        String session2 = manager.getSession("user2");
        String session3 = manager.getSession("user3");

        manager.removeSession(session2);
        manager.removeSession(session3);
    }
}