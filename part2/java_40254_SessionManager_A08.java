import java.util.HashMap;
import java.util.Map;

public class java_40254_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_40254_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public static void main(String[] args) {
        VanillaJavaSessionManager sessionManager = new VanillaJavaSessionManager();

        String session1 = sessionManager.createSession("user1");
        String session2 = sessionManager.createSession("user2");
        String session3 = sessionManager.createSession("user3");

        System.out.println(sessionManager.getSession("user1")); // should print session1
        System.out.println(sessionManager.getSession("user2")); // should print session2
        System.out.println(sessionManager.getSession("user3")); // should print session3

        sessionManager.deleteSession("user2");
        System.out.println(sessionManager.getSession("user2")); // should be null
    }
}