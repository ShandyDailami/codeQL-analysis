import java.util.HashMap;
import java.util.Map;

public class java_32367_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_32367_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(sessionMap.size() + 1); // Session IDs are sequential numbers
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    public String getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            throw new IllegalArgumentException("User not found in session.");
        }
    }

    public void deleteSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
        } else {
            throw new IllegalArgumentException("User not found in session.");
        }
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        String session1 = sessionManager.createSession("user1");
        String session2 = sessionManager.createSession("user2");
        String session3 = sessionManager.createSession("user3");

        System.out.println("Session1: " + session1);
        System.out.println("Session2: " + session2);
        System.out.println("Session3: " + session3);

        String userSession = sessionManager.getSession("user1");
        System.out.println("User's session: " + userSession);

        sessionManager.deleteSession("user2");

        try {
            String inactiveSession = sessionManager.getSession("user2");
            System.out.println("Inactive session: " + inactiveSession);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}