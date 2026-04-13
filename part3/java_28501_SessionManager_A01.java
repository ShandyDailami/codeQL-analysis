import java.util.HashMap;

public class java_28501_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_28501_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");
        String username = sessionManager.getUsername("session1");
        System.out.println("Username: " + username); // Output: Username: user1

        sessionManager.deleteSession("session1");
        username = sessionManager.getUsername("session1");
        System.out.println("Username: " + username); // Output: Username: null
    }
}