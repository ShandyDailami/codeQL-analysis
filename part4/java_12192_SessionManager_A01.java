import java.util.*;

public class java_12192_SessionManager_A01 {
    private List<String> sessions = new ArrayList<>();

    // Session creation
    public void createSession(String username) {
        sessions.add(username);
        System.out.println("Session created for user: " + username);
    }

    // Session validation
    public boolean validateSession(String username) {
        return sessions.contains(username);
    }

    // Session deletion
    public void deleteSession(String username) {
        if (sessions.contains(username)) {
            sessions.remove(username);
            System.out.println("Session deleted for user: " + username);
        } else {
            System.out.println("No session found for user: " + username);
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.createSession("John");
        sm.createSession("Sara");

        sm.validateSession("John"); // Valid session
        sm.validateSession("Mike"); // Invalid session

        sm.deleteSession("John"); // Deletes the valid session
        sm.deleteSession("John"); // Try to delete a non-existing session

        sm.validateSession("John"); // Invalid session
        sm.validateSession("Sara"); // Valid session
    }
}