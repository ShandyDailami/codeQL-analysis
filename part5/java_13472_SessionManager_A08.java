import java.util.HashMap;
import java.util.Map;

public class java_13472_SessionManager_A08 {

    private Map<String, Object> sessionMap;

    public java_13472_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        this.sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session and store a user in it
        User user = new User("John", "Doe", "john@example.com");
        sessionManager.createSession("session1", user);

        // Retrieve the user from the session
        Object retrievedUser = sessionManager.getSession("session1");
        System.out.println(retrievedUser);
    }

    class User {
        private String firstName;
        private String lastName;
        private String email;

        public java_13472_SessionManager_A08(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        // Getters and setters omitted for brevity...
    }
}