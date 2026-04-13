public class java_24992_CredentialValidator_A08 {

    // Predefined set of credentials
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public static boolean validate(String username, String password) {
        // Check if the provided username and password matches the predefined ones
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validate method
        boolean result = validate("test", "test");
        System.out.println("Credentials are valid: " + result);
    }
}