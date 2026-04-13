import java.util.HashMap;

public class java_06676_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_06676_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String user, String password) {
        // We are only storing passwords for demonstration purposes. In a real application,
        // we should not store passwords in plaintext, but rather hash them.
        // In this example, we are simply storing the password.
        sessions.put(user, password);
    }

    public String getSessionPassword(String user) {
        return sessions.get(user);
    }

    public boolean validateSession(String user, String password) {
        // We are only comparing stored passwords for demonstration purposes. In a real application,
        // we should compare the hashed passwords.
        return password.equals(sessions.get(user));
    }
}