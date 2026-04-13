import java.util.HashMap;

public class java_06047_SessionManager_A01 {

    private HashMap<String, String> sessions;

    public java_06047_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String user, String sessionId) {
        sessions.put(sessionId, user);
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.createSession("User1", "Session1");
        manager.createSession("User2", "Session2");

        System.out.println("Session1 user: " + manager.getUser("Session1"));
        System.out.println("Session2 user: " + manager.getUser("Session2"));

        manager.deleteSession("Session1");

        System.out.println("Session1 user after deleting: " + manager.getUser("Session1"));
    }
}