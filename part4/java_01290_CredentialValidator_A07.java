public class java_01290_CredentialValidator_A07 implements CredentialValidator {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordValidator.class);

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) {
        String password = credentials.getPassword();

        // rule 1: password length should be more than 8
        if (password.length() < 8) {
            LOG.warn("Invalid password: password length should be more than 8");
            return false;
        }

        // rule 2: password should contain at least one digit
        if (!hasDigit(password)) {
            LOG.warn("Invalid password: password should contain at least one digit");
            return false;
        }

        // rule 3: password should contain at least one uppercase letter
        if (!hasUpperCase(password)) {
            LOG.warn("Invalid password: password should contain at least one uppercase letter");
            return false;
        }

        // rule 4: password should contain at least one lowercase letter
        if (!hasLowerCase(password)) {
            LOG.warn("Invalid password: password should contain at least one lowercase letter");
            return false;
        }

        // rule 5: password should contain at least one special character
        if (!hasSpecialChar(password)) {
            LOG.warn("Invalid password: password should contain at least one special character");
            return false;
        }

        LOG.info("Password validation successful");
        return true;
    }

    private boolean hasDigit(String s) {
        // Implement your password validation here
        // This is just an example, you should replace it with your own logic
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasUpperCase(String s) {
        // Implement your password validation here
        // This is just an example, you should replace it with your own logic
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(String s) {
        // Implement your password validation here
        // This is just an example, you should replace it with your own logic
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialChar(String s) {
        // Implement your password validation here
        // This is just an example, you should replace it with your own logic
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)) {
                return true;
            }
        }
        return false;
    }
}