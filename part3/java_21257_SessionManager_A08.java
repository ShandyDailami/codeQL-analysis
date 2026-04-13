public class java_21257_SessionManager_A08 {
    // We use a static User to represent the logged-in user
    private static User loggedInUser;

    // User is a simple class to hold a username
    public static class User {
        private String username;

        public java_21257_SessionManager_A08(String username) {
            this.username = username;
        }

        public String getUsername() {
            return this.username;
        }
    }

    // Access is a method that allows access if the user is logged in
    public static boolean access(User user) {
        if(user == loggedInUser) {
            System.out.println("Access granted for " + user.getUsername());
            return true;
        } else {
            System.out.println("Access denied for " + user.getUsername());
            return false;
        }
    }

    // Log in a user
    public static void login(String username) {
        loggedInUser = new User(username);
    }

    // Main method to test the session manager
    public static void main(String[] args) {
        login("Alice");
        access(new User("Alice"));
        access(new User("Bob"));
    }
}