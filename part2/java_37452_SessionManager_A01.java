import java.util.HashMap;
import java.util.Map;

public class java_37452_SessionManager_A01 {
    private Map<String, Object> sessionMap;

    public java_37452_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a new session
        manager.createSession("session1", new User("John Doe", "john@example.com"));

        // Retrieve a session
        User user = (User) manager.getSession("session1");
        System.out.println("User: " + user.getName() + ", Email: " + user.getEmail());

        // Update a session
        user.setEmail("john.doe@example.com");
        manager.updateSession("session1", user);

        // Retrieve the updated session
        user = (User) manager.getSession("session1");
        System.out.println("Updated User: " + user.getName() + ", Email: " + user.getEmail());

        // Delete a session
        manager.deleteSession("session1");
    }
}

class User {
    private String name;
    private String email;

    public java_37452_SessionManager_A01(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}