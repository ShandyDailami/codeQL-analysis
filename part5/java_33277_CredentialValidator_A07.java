public class java_33277_CredentialValidator_A07 {

    public static boolean validate(String username, String password) {
        // Check if username or password is null
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        // Check if usernames and passwords are the same
        if (username.equals(password)) {
            throw new IllegalArgumentException("Username and password must be different");
        }

        // If all checks pass, return true
        return true;
    }

    public static void main(String[] args) {
        // Test with valid credentials
        System.out.println(validate("test", "test")); // Should print true

        // Test with invalid credentials
        try {
            System.out.println(validate("test", null)); // Should throw IllegalArgumentException
            System.out.println(validate(null, "test")); // Should throw IllegalArgumentException
            System.out.println(validate("test", "test")); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}