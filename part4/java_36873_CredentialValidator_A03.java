public class java_36873_CredentialValidator_A03 {

    // Predefined patterns to match
    private static final String UPPERCASE = "([A-Z])";
    private static final String LOWERCASE = "([a-z])";
    private static final String DIGIT = "([0-9])";
    private static final String SPECIAL_CHARACTER = "([$@#])";
    private static final String PASSWORD_PATTERN = UPPERCASE + LOWERCASE + DIGIT + SPECIAL_CHARACTER;

    public static void main(String[] args) {
        String password = "Password@123";
        System.out.println(validatePassword(password));
    }

    public static boolean validatePassword(String password) {
        // If password is null or it does not match the pattern
        if (password == null || !password.matches(PASSWORD_PATTERN)) {
            return false;
        }

        // Password is valid
        return true;
    }
}