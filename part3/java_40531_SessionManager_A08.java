import java.util.HashMap;
import java.util.Map;

public class java_40531_SessionManager_A08 {

    // Map to hold session IDs and user objects
    private Map<String, User> sessionMap;

    public java_40531_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(User user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get a user from a session
    public User getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean checkSessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to generate a session ID
    private String generateSessionId() {
        // This is a mock session ID generation.
        // In a real-world scenario, this would involve more complex logic.
        return "A08_IntegrityFailure";
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        User user = new User("John Doe", "john@example.com", "password");
        String sessionId = sessionManager.createSession(user);
        System.out.println("Created session ID: " + sessionId);
        User retrievedUser = sessionManager.getUserFromSession(sessionId);
        System.out.println("Retrieved user: " + retrievedUser.getName());
        sessionManager.removeSession(sessionId);
        System.out.println("Session removed: " + sessionManager.checkSessionExists(sessionId));
    }
}

class User {
    private String name;
    private String email;
    private String password;

    public java_40531_SessionManager_A08(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}