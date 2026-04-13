public class java_18009_CredentialValidator_A08 {
    // Define a predefined list of users and their passwords.
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
    }

    // User class to hold user details.
    public static class User {
        private String username;
        private String password;

        public java_18009_CredentialValidator_A08(String username, String password) {
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

    // Credential validator method.
    public static boolean validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the validate method.
        System.out.println(validate("user1", "password1")); // should print: true
        System.out.println(validate("user4", "password4")); // should print: false
    }
}