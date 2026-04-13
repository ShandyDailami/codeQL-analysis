import java.util.HashMap;
import java.util.UUID;

public class java_13383_SessionManager_A07 {
    private HashMap<UUID, String> sessions;
    private HashMap<String, String> credentials;

    public java_13383_SessionManager_A07() {
        this.sessions = new HashMap<>();
        this.credentials = new HashMap<>();
        // Initialize credentials here, for example:
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public String createSession(String username, String password) {
        if (!this.credentials.containsKey(username) || !this.credentials.get(username).equals(password)) {
            throw new AuthFailureException("Invalid username or password");
        }

        UUID sessionId = UUID.randomUUID();
        this.sessions.put(sessionId, username);
        return sessionId.toString();
    }

    public String getUsername(String sessionId) {
        return this.sessions.get(UUID.fromString(sessionId));
    }

    public void removeSession(String sessionId) {
        this.sessions.remove(UUID.fromString(sessionId));
    }
}