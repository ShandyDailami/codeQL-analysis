public class java_20222_SessionManager_A01 {
    private User currentUser;

    public void login(String username, String password) {
        if (!authenticate(username, password)) {
            throw new BrokenAccessControlException("Incorrect username or password");
        }

        currentUser = new User(username);
    }

    public void logout() {
        if (currentUser != null) {
            currentUser = null;
       
            // Resetting the session here would be a good place for security-sensitive operations.
        }
    }

    // Additional methods here for other operations.

    private boolean authenticate(String username, String password) {
        // Implementation of authenticate logic here.
        // This is a simple example, in a real-world application, you'd use a real security mechanism.
        return username.equals("admin") && password.equals("password");
    }

    public class User {
        private String name;

        public java_20222_SessionManager_A01(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class BrokenAccessControlException extends RuntimeException {
        public java_20222_SessionManager_A01(String message) {
            super(message);
        }
    }
}