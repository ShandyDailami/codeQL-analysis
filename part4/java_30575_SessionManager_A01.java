import java.util.ArrayList;
import java.util.List;

public class java_30575_SessionManager_A01 {
    private List<String> sessions;

    public java_30575_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public void createSession(String user) {
        sessions.add(user);
        System.out.println("Session created for user: " + user);
    }

    public void deleteSession(String user) {
        sessions.remove(user);
        System.out.println("Session deleted for user: " + user);
    }

    public boolean isSessionActive(String user) {
        return sessions.contains(user);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // create a session
        sessionManager.createSession("user1");

        // attempt to access a session that doesn't exist
        sessionManager.isSessionActive("user2");

        // delete a session
        sessionManager.deleteSession("user1");

        // attempt to access a session that doesn't exist
        sessionManager.isSessionActive("user2");
    }
}