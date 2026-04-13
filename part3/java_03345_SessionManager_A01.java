public class java_03345_SessionManager_A01 {
    private User currentUser;

    // User represents the current user
    public class User {
        private String name;

        public java_03345_SessionManager_A01(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // Session represents the current session
    public class Session {
        private User user;

        public java_03345_SessionManager_A01(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    // Method to create a new session
    public Session createSession(String username) {
        // Create a new user
        User user = new User(username);
        // Create a new session with the user
        Session session = new Session(user);
        // Return the session
        return session;
    }

    // Method to allow access to a session
    public boolean allowAccess(Session session) {
        // Get the user in the session
        User sessionUser = session.getUser();
        // Check if the user is the same as the current user
        if (sessionUser.getName().equals(currentUser.getName())) {
            return true;
        }
        // If not, return false
        return false;
    }

    // Method to allow access to a session
    public boolean allowAccess(Session session, User user) {
        // Check if the user is the same as the current user
        if (user.getName().equals(currentUser.getName())) {
            return true;
        }
        // If not, return false
        return false;
    }

    // Set the current user
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}