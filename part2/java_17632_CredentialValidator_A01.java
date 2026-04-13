public class java_17632_CredentialValidator_A01 {

    // Hardcoded set of valid credentials
    private static final Map<String, String> VALID_CREDENTIALS = new HashMap<>();

    static {
        VALID_CREDENTIALS.put("user1", "password1");
        VALID_CREDENTIALS.put("user2", "password2");
        // Add more valid credentials as needed
    }

    public static boolean validateCredentials(String username, String password) {
        return password.equals(VALID_CREDENTIALS.getOrDefault(username, ""));
    }

    public static void main(String[] args) {
        // Test the validator
        boolean valid = CredentialValidator.validateCredentials("user1", "password1");
        System.out.println("Credentials are valid: " + valid);

        valid = CredentialValidator.validateCredentials("user3", "password3");
        System.out.println("Credentials are valid: " + valid);
    }
}