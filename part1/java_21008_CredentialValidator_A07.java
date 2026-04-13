public class java_21008_CredentialValidator_A07 {

    // Hardcoded set of users and passwords
    private static final String[][] USERS_PASSWORDS = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"},
        {"user5", "password5"}
    };

    // Method to authenticate user
    public boolean authenticate(String username, String password) {
        for (String[] user : USERS_PASSWORDS) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test user1 with correct password
        if (validator.authenticate("user1", "password1")) {
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Invalid credentials");
        }

        // Test user6 with incorrect password
        if (!validator.authenticate("user6", "incorrectpassword")) {
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}