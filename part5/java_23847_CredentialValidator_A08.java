public class java_23847_CredentialValidator_A08 implements CredentialValidator {

    private static final Logger logger = Logger.getLogger(CustomCredentialValidator.class);

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String username = credential.getIdentifier();
        char[] password = credential.getPassword();

        // Check if the password is at least 8 characters long and contains at least one digit and one lowercase letter
        boolean isValidPassword = (password.length >= 8) &&
                (hasDigit(password) && hasLowerCase(password));

        logger.info("Checking password for user: " + username + ", isValid: " + isValidPassword);

        return isValidPassword;
    }

    private boolean hasDigit(char[] password) {
        for (char c : password) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(char[] password) {
        for (char c : password) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }
}