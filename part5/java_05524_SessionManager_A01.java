public class java_05524_SessionManager_A01 {
    private User currentUser;

    // User class for simplicity
    public class User {
        private String username;
        private String password;

        public java_05524_SessionManager_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public java_05524_SessionManager_A01() {
        this.currentUser = null;
    }

    // Method to check if a user is authenticated
    public boolean authenticate(String username, String password) {
        // Here we're checking for a hard-coded username/password comparison.
        // In a real-world scenario, you would want to use a more secure mechanism for authentication.
        if (currentUser == null || !currentUser.getUsername().equals(username) || !currentUser.getPassword().equals(password)) {
            currentUser = new User(username, password);
            return true;
        }
        return false;
    }

    // Method to check if the current user is authenticated
    public boolean isAuthenticated() {
        return currentUser != null;
    }

    // Method to get the username of the current user
    public String getUsername() {
        if (isAuthenticated()) {
            return currentUser.getUsername();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.authenticate("user1", "password1");
        System.out.println(sessionManager.isAuthenticated());
        System.out.println(sessionManager.getUsername());

        // Attempting to bypass authentication
        sessionManager.authenticate("wrong_username", "wrong_password");
        System.out.println(sessionManager.isAuthenticated());
        System.out.println(sessionManager.getUsername());
    }
}