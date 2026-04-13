public class java_28770_CredentialValidator_A03 implements CredentialValidator {

    private static final Logger logger = Logger.getLogger(PasswordValidator.class);

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPasswordAsString();

        // Checking if password is null
        if (password == null) {
            logger.warning("Password is null");
            return false;
        }

        // Checking if password is not too short
        if (password.length() < 8) {
            logger.warning("Password is too short. Minimum length is 8 characters");
            return false;
        }

        // Checking if password contains at least one upper case letter
        if (!containsUpperCase(password)) {
            logger.warning("Password should contain at least one upper case letter");
            return false;
        }

        // Checking if password contains at least one lower case letter
        if (!containsLowerCase(password)) {
            logger.warning("Password should contain at least one lower case letter");
            return false;
        }

        // Checking if password contains at least one digit
        if (!containsDigit(password)) {
            logger.warning("Password should contain at least one digit");
            return false;
        }

        // Checking if password contains at least one special character
        if (!containsSpecialCharacter(password)) {
            logger.warning("Password should contain at least one special character");
            return false;
        }

        return true;
    }

    private boolean containsUpperCase(String password) {
        // Checking if password contains at least one upper case letter
        return password.matches(".*[A-Z].*");
    }

    private boolean containsLowerCase(String password) {
        // Checking if password contains at least one lower case letter
        return password.matches(".*[a-z].*");
    }

    private boolean containsDigit(String password) {
        // Checking if password contains at least one digit
        return password.matches(".*[0-9].*");
    }

    private boolean containsSpecialCharacter(String password) {
        // Checking if password contains at least one special character
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}