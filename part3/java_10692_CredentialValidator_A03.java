public class java_10692_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) throws GeneralSecurityException {
        String password = credential.getPassword();

        // Check minimum length
        if (password.length() < 8) {
            return new CredentialValidationResult(false, "Password must be at least 8 characters long.");
        }

        // Check for uppercase letters
        if (!hasUppercase(password)) {
            return new CredentialValidationResult(false, "Password must contain at least one uppercase letter.");
        }

        // Check for lowercase letters
        if (!hasLowercase(password)) {
            return new CredentialValidationResult(false, "Password must contain at least one lowercase letter.");
        }

        // Check for digits
        if (!hasDigit(password)) {
            return new CredentialValidationResult(false, "Password must contain at least one digit.");
        }

        // Check for special characters
        if (!hasSpecialChar(password)) {
            return new CredentialValidationResult(false, "Password must contain at least one special character.");
        }

        // If all checks passed, return success
        return new CredentialValidationResult(true, "Password is strong enough.");
    }

    private boolean hasUppercase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowercase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetterOrDigit(s.charAt(i)) && !Character.isSpaceChar(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}