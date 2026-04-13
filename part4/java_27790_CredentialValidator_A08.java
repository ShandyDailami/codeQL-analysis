public class java_27790_CredentialValidator_A08 {

    // The pattern that the password must match
    private static final String PASSWORD_PATTERN = "^.{8,}$";

    public static boolean validatePassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        // Test the validator
        System.out.println(validatePassword("test"));  // Outputs: false
        System.out.println(validatePassword("test123456"));  // Outputs: true
    }
}