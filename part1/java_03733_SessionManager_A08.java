import java.util.HashMap;

public class java_03733_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_03733_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = Integer.toHexString(user.hashCode());
        this.sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return this.sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        this.sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("alice");
        System.out.println("Created session: " + sessionId);

        String user = sessionManager.getUser(sessionId);
        System.out.println("Retrieved user: " + user);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}