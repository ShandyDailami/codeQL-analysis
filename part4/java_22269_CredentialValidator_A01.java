public class java_22269_CredentialValidator_A01 {

    // Predefined password pattern
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean validatePassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        // Test the validator
        System.out.println(validatePassword("Password@123")); // Should print true
        System.out.println(validatePassword("password")); // Should print false
        System.out.println(validatePassword("PASSWORD")); // Should print false
        System.out.println(validatePassword("PASSWORD@123")); // Should print false
        System.out.println(validatePassword("Password@1")); // Should print false
    }
}