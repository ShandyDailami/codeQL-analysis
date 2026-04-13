import java.util.HashMap;

public class java_41168_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_41168_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String sessionId = sessionManager.createSession("Alice");
        System.out.println("Created session: " + sessionId);
        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);
        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}