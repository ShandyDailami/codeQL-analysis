public class java_02668_CredentialValidator_A03 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBER = "1234567890";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) {
        String password = credentials.getPassword();

        // Check for length
        if (password.length() < 8) {
            return false;
        }

        // Check for numbers
        if (!password.contains(NUMBER)) {
            return false;
        }

        // Check for special characters
        if (!password.contains(SPECIAL_CHARACTERS)) {
            return false;
        }

        // Check for lowercase and uppercase
        if (!(password.matches(".*[A-Z].*") && password.matches(".*[a-z].*"))) {
            return false;
        }

        return true;
    }
}