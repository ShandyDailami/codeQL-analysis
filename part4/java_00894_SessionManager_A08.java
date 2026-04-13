import java.util.HashMap;

public class java_00894_SessionManager_A08 {
    // A simple in-memory store for sessions.
    // Note that this is not a secure way to store sessions, but it's the simplest possible way to do it.
    private HashMap<String, String> sessionStore = new HashMap<>();

    public String createSession(String userId) {
        // Create a session and store the userId in the sessionStore.
        // For a real-world application, you would also want to use a secure random UUID instead of just a simple userId.
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        // Retrieve the userId from the sessionStore.
        return sessionStore.get(sessionId);
    }

    public void destroySession(String sessionId) {
        // Remove the session from the sessionStore.
        sessionStore.remove(sessionId);
    }
}