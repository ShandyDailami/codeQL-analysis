public class java_05440_CredentialValidator_A08 {

    // Pre-defined pattern
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    // Method to validate the password
    public boolean isPasswordValid(String password) {
        if (password == null) {
            return false;
        }
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isPasswordValid("Password@123")); // True
        System.out.println(validator.isPasswordValid("password")); // False
    }
}