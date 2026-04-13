public class java_39349_SessionManager_A07 {

    // Static reference to the user in memory for testing
    private static User loggedInUser;

    // User class for testing
    public static class User {
        public String username;
        public String password;

        public java_39349_SessionManager_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        try {
            login("alice", "password123");
            System.out.println("User is logged in as " + loggedInUser.username);
            logout();
            System.out.println("User is logged out");
            login("bob", "wrongpassword");
            System.out.println("Trying to log in as bob...");
            login("bob", "password123");
        } catch (AuthFailureException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    // Method to login the user, throws AuthFailureException if authentication fails
    public static void login(String username, String password) throws AuthFailureException {
        if ("alice".equals(username) && "password123".equals(password)) {
            loggedInUser = new User(username, password);
        } else {
            throw new AuthFailureException("Invalid username or password");
        }
    }

    // Method to logout the user
    public static void logout() {
        loggedInUser = null;
    }
}