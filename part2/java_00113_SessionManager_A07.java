import java.util.HashMap;

public class java_00113_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_00113_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.addSession("session1", "user1");
        sessionManager.addSession("session2", "user2");

        System.out.println(sessionManager.getUserFromSession("session1"));
        System.out.println(sessionManager.getUserFromSession("session2"));

        sessionManager.removeSession("session1");
        System.out.println(sessionManager.getUserFromSession("session1"));
    }
}