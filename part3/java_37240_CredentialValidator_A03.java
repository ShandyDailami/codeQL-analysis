public class java_37240_CredentialValidator_A03 {

    // Hardcoded password.
    private static final String HARDCODED_PASSWORD = "12345";

    public static boolean validateCredentials(String username, String password) {
        // Checks if the provided password matches the hardcoded password.
        return password.equals(HARDCODED_PASSWORD);
    }

    public static void main(String[] args) {
        // Test the method.
        System.out.println(validateCredentials("test", "test")); // Should print true.
        System.out.println(validateCredentials("test", "wrong")); // Should print false.
    }
}