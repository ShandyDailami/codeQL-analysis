public class java_22596_CredentialValidator_A08 {

    // A simple password pattern, you can replace this with your own pattern
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validatePassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        SimpleCredentialValidator validator = new SimpleCredentialValidator();

        // Testing
        System.out.println(validator.validatePassword("Password@123")); // should return true
        System.out.println(validator.validatePassword("password")); // should return false
    }
}