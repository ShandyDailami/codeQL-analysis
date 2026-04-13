import java.util.HashMap;
import java.util.Map;

public class java_27348_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27348_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) throws AuthFailure {
        if (!sessionMap.containsKey(userId)) {
            throw new AuthFailure("No such user in the system.");
        }
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create session
        manager.createSession("user1", "session1");

        // Get session
        try {
            System.out.println(manager.getSession("user1"));
        } catch (AuthFailure e) {
            e.printStackTrace();
        }

        // Delete session
        manager.deleteSession("user1");
    }
}