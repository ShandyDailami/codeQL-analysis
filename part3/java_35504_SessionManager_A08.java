import java.util.HashMap;
import java.util.Map;

public class java_35504_SessionManager_A08 {

    private Map<String, String> users;

    public java_35504_SessionManager_A08() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public String getSession(String user, String password) {
        String storedPassword = users.get(user);
        if (storedPassword == null || !storedPassword.equals(password)) {
            return null;
        }

        String sessionId = generateSessionId();
        users.put(sessionId, user);
        return sessionId;
    }

    public void closeSession(String sessionId) {
        String user = users.get(sessionId);
        if (user != null) {
            users.remove(sessionId);
            users.put(user, null);
        }
    }

    private String generateSessionId() {
        // This is a simplistic way to generate a session ID. In a real-world application,
        // you would likely use a UUID or some other kind of unique identifier.
        return Long.toString(System.nanoTime());
    }
}