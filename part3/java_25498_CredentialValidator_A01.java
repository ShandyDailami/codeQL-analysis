public class java_25498_CredentialValidator_A01 {

    // Minimum length of password (8 characters)
    private static final int MIN_PASSWORD_LENGTH = 8;

    // Must contain at least one uppercase letter
    private static final String REGEX_UPPERCASE = ".*[A-Z]+.*";

    // Must contain at least one lowercase letter
    private static final String REGEX_LOWERCASE = ".*[a-z]+.*";

    // Must contain at least one digit
    private static final String REGEX_DIGIT = ".*[0-9]+.*";

    // Must contain at least one special character
    private static final String REGEX_SPECIAL_CHAR = ".*[^a-zA-Z0-9]+.*";

    public static boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (!password.matches(REGEX_UPPERCASE)) {
            return false;
        }

        if (!password.matches(REGEX_LOWERCASE)) {
            return false;
        }

        if (!password.matches(REGEX_DIGIT)) {
            return false;
        }

        if (!password.matches(REGEX_SPECIAL_CHAR)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPasswordStrongEnough("Password@123")); // Returns true
        System.out.println(isPasswordStrongEnough("password")); // Returns false
        System.out.println(isPasswordStrongEnough("PASSWORD")); // Returns false
        System.out.println(isPasswordStrongEnough("PASSWORD@123")); // Returns false
        System.out.println(isPasswordStrongEnough("PASSWORD@1234")); // Returns true
    }
}