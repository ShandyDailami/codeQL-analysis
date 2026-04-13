public class java_30259_SessionManager_A08 {

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a user
        User user = new User("John Doe", "john.doe@example.com");

        // Create a session
        Session session = sessionManager.createSession();

        // Add the user to the session
        sessionManager.addUserToSession(user, session);
    }
}

class User {
    private String name;
    private String email;

    public java_30259_SessionManager_A08(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // getters and setters
}

class Session {
    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    // other session related methods
}

class SessionManager {
    public Session createSession() {
        return new Session();
    }

    public void addUserToSession(User user, Session session) {
        session.addUser(user);
    }
}