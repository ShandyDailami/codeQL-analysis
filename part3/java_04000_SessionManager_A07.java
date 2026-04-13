public class java_04000_SessionManager_A07 {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        Session session = sessionManager.createSession();

        // Get a user from the session
        User user = session.getUser("userId");

        System.out.println("User: " + user.getName());
    }
}

class User {
    private String name;

    public java_04000_SessionManager_A07(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Session {
    private User user;

    public java_04000_SessionManager_A07(User user) {
        this.user = user;
    }

    public User getUser(String userId) {
        // Placeholder for security-sensitive operation
        if (userId.equals("userId")) {
            return new User("Test User");
        } else {
            throw new AuthFailureException();
        }
    }
}

class SessionManager {
    public Session createSession() {
        // Placeholder for security-sensitive operation
        return new Session(new User("Session User"));
    }
}