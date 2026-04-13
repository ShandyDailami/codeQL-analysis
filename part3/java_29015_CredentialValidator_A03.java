public class java_29015_CredentialValidator_A03 {

    // Simple password strength checker
    public static boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[@#$%^&*()].*")) {
            return false;
        }
        return true;
    }

    public static class CustomValidator implements javax.security.auth.credential.CredentialValidator {

        @Override
        public boolean validate(javax.security.auth.credential.Credential credential) {
            String password = credential.getCredentialIdentifier();
            return isPasswordStrong(password);
        }

        @Override
        public String getMessage() {
            return null;
        }
    }

    public static void main(String[] args) {
        javax.security.auth.credential.CredentialValidator validator = new CustomValidator();

        // Use the validator
        // ...
    }
}