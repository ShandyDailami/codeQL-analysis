public class java_42129_CredentialValidator_A01 {

    // Static user database for simplicity
    private static User[] users = new User[] {
        new User("Alice", "password123", Role.ADMIN),
        new User("Bob", "password456", Role.USER),
        new User("Charlie", "password789", Role.USER)
    };

    // User represents a user in the system with a name, password and role
    private static class User {
        String name;
        String password;
        Role role;

        User(String name, String password, Role role) {
            this.name = name;
            this.password = password;
            this.role = role;
        }
    }

    // Role represents a role in the system (Admin, User)
    private static enum Role {
        ADMIN, USER
    }

    public static boolean validate(String username, String password) {
        // In a real-world scenario, we would not compare the passwords directly,
        // but instead compare hashed versions of the passwords. Here we simulate that.
        for (User user : users) {
            if (user.name.equals(username) && user.password.equals(password)) {
                // If the username and password match a user in our database, we return true
                return true;
            }
        }
        // If no match is found, we return false
        return false;
    }

    // Simple main to test the validate method
    public static void main(String[] args) {
        System.out.println(validate("Alice", "password123")); // true
        System.out.println(validate("Bob", "wrongpassword")); // false
        System.out.println(validate("Charlie", "password789")); // false
    }
}