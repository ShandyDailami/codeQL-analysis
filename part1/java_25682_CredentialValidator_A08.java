public class java_25682_CredentialValidator_A08 {
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final String WEAK_PASSWORD_PATTERN = "^(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).$";

    public boolean isPasswordStrong(String password) {
        if (passwordMatchesPattern(password, STRONG_PASSWORD_PATTERN)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPasswordWeak(String password) {
        if (passwordMatchesPattern(password, WEAK_PASSWORD_PATTERN)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean passwordMatchesPattern(String password, String pattern) {
        return password.matches(pattern);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test a strong password
        String strongPassword = "ThisIsAStrongPassword1!";
        if (validator.isPasswordStrong(strongPassword)) {
            System.out.println("The password is strong");
        } else {
            System.out.println("The password is weak");
        }

        // Test a weak password
        String weakPassword = "weakpassword";
        if (validator.isPasswordWeak(weakPassword)) {
            System.out.println("The password is strong");
        } else {
            System.out.println("The password is weak");
        }
    }
}