public class java_07359_CredentialValidator_A07 {

    // Using a static list of users for simplicity.
    // In real-world application, you should use a more robust method to authenticate the user.
    private static List<User> users = new ArrayList<>();

    // Add users to the list.
    static {
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
    }

    // This is our main class, the user is trying to log in.
    public static class User {
        private String username;
        private String password;

        public java_07359_CredentialValidator_A07(String username, String password) {
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

    // Our main method.
    public static void main(String[] args) {
        authenticateUser("user1", "password1");
        authenticateUser("user4", "password4");
    }

    // CredentialValidator class, the user is trying to log in.
    public static boolean authenticateUser(String username, String password) {
        // Step 1: Find the user in the list.
        User user = findUser(username);

        // Step 2: Check if the user exists.
        if (user == null) {
            System.out.println("Invalid username");
            return false;
        }

        // Step 3: Check if the password matches.
        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("User authenticated successfully");
        return true;
    }

    // Method to find the user in the list.
    private static User findUser(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}