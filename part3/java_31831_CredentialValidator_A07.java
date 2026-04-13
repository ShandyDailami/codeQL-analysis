public class java_31831_CredentialValidator_A07 {

    // Hard-coded set of credentials.
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static boolean validateCredentials(String providedUsername, String providedPassword) {
        return USERNAME.equals(providedUsername) && PASSWORD.equals(providedPassword);
    }

    public static void main(String[] args) {
        // Test the validator.
        System.out.println(validateCredentials("user", "password")); // Should print true.
        System.out.println(validateCredentials("wrongUsername", "password")); // Should print false.
        System.out.println(validateCredentials("user", "wrongPassword")); // Should print false.
        System.out.println(validateCredentials("wrongUsername", "wrongPassword")); // Should print false.
    }
}