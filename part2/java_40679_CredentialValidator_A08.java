public class java_40679_CredentialValidator_A08 {

    // Hardcoded password for authentication
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static boolean validate(String password) {
        // If the password matches the hardcoded password, return true
        // Otherwise, return false
        return password.equals(AUTHENTICATED_PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validate method
        System.out.println(validate("wrongPassword")); // False
        System.out.println(validate("password")); // True
    }
}