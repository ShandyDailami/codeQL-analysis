public class java_41373_CredentialValidator_A01 {

    // Constants for minimum password strength
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 16;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "1234567890";

    // Method to check if password meets complexity requirements
    public boolean isPasswordStrong(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH
                || password.length() > MAX_PASSWORD_LENGTH
                || !containsUpperCase(password)
                || !containsLowerCase(password)
                || !containsNumber(password)
                || !containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    // Method to check if password contains uppercase letter
    private boolean containsUpperCase(String password) {
        return password.matches("(?=.*[A-Z])");
    }

    // Method to check if password contains lowercase letter
    private boolean containsLowerCase(String password) {
        return password.matches("(?=.*[a-z])");
    }

    // Method to check if password contains a number
    private boolean containsNumber(String password) {
        return password.matches("(?=.*[0-9])");
    }

    // Method to check if password contains a special character
    private boolean containsSpecialCharacter(String password) {
        return password.matches("(?=.*[" + SPECIAL_CHARACTERS + "])");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test passwords
        String password1 = "strongpassword";
        String password2 = "weakpassword";

        if (validator.isPasswordStrong(password1)) {
            System.out.println(password1 + " is strong.");
        } else {
            System.out.println(password1 + " is weak.");
        }

        if (validator.isPasswordStrong(password2)) {
            System.out.println(password2 + " is strong.");
        } else {
            System.out.println(password2 + " is weak.");
        }
    }
}