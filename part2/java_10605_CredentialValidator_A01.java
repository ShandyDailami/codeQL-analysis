public class java_10605_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPasswordAsString();

        // Password length check
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase, lowercase, numbers and special characters
        if (!(password.matches(".*[A-Z].*")) || !(password.matches(".*[a-z].*")) || !(password.matches(".*\\d.*")) || !(password.matches(".*[!@#$%^&*(),.?\":{}|<>].*"))) {
            return false;
        }

        // Check for common patterns
        if (password.matches(".*password.*")) {
            return false;
        }

        // Check for common words
        if (password.matches(".*(the end|the end|it is over|over here).*")) {
            return false;
        }

        return true;
    }
}