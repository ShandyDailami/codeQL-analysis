import java.util.HashMap;

public class java_09934_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_09934_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String username) {
        sessions.put(username, "session");
    }

    public String getSession(String username) {
        if (sessions.containsKey(username)) {
            return sessions.get(username);
        } else {
            throw new AuthFailure(); // A simple exception for authentication failure
        }
    }

    public void endSession(String username) {
        sessions.remove(username);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Start a session
        manager.startSession("alice");

        // Get a session
        System.out.println(manager.getSession("alice"));

        // End a session
        manager.endSession("alice");

        // Try to get a session that doesn't exist
        try {
            System.out.println(manager.getSession("bob"));
        } catch (AuthFailure e) {
            System.out.println("Authentication failure");
        }
    }
}