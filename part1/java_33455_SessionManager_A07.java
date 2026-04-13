public class java_33455_SessionManager_A07 {
    // A simple in-memory store for users
    private static Map<String, User> userMap = new HashMap<>();

    // User class
    public static class User {
        private String username;
        private String password;

        public java_33455_SessionManager_A07(String username, String password) {
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

    // Login method
    public static User login(String username, String password) {
        User user = userMap.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    // Logout method
    public static void logout(User user) {
        userMap.remove(user.getUsername());
    }

    // Main method
    public static void main(String[] args) {
        // Add some users
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        userMap.put(user1.getUsername(), user1);
        userMap.put(user2.getUsername(), user2);

        // Log in user1
        User user = login("user1", "password1");
        if (user != null) {
            System.out.println("User " + user.getUsername() + " logged in successfully.");
        } else {
            System.out.println("Login failed.");
        }

        // Log out user1
        logout(user);

        // Log in user2
        user = login("user2", "password2");
        if (user != null) {
            System.out.println("User " + user.getUsername() + " logged in successfully.");
        } else {
            System.out.println("Login failed.");
        }
    }
}