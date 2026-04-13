public class java_33841_CredentialValidator_A01 implements CredentialValidator {

    // The minimum password length
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    // The maximum password length
    private static final int MAXIMUM_PASSWORD_LENGTH = 20;

    // The minimum number of upper case letters in the password
    private static final int MINIMUM_UPPERCASE_CHARS = 1;

    // The minimum number of lower case letters in the password
    private static final int MINIMUM_LOWERCASE_CHARS = 1;

    // The minimum number of digits in the password
    private static final int MINIMUM_DIGITS = 1;

    // The minimum number of non-alphanumeric characters in the password
    private static final int MINIMUM_NON_ALPHANUMERIC_CHARS = 1;

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPassword();

        // Check the length of the password
        if (password.length() < MINIMUM_PASSWORD_LENGTH || password.length() > MAXIMUM_PASSWORD_LENGTH) {
            return false;
        }

        // Check the presence of upper case letters
        if (password.equals(password.toLowerCase()) || 
            password.equals(password.toUpperCase()) || 
            !password.matches(".*[A-Z].*") ||
            !password.matches(".*[a-z].*") ||
            !password.matches(".*[0-9].*")) {
            return false;
        }

        // Check the number of digits
        if (password.matches(".*[0-9].*") && password.length() < MINIMUM_DIGITS) {
            return false;
        }

        // Check the number of non-alphanumeric characters
        if (password.matches(".*[^a-zA-Z0-9].*") && password.length() < MINIMUM_NON_ALPHANUMERIC_CHARS) {
            return false;
        }

        return true;
    }
}