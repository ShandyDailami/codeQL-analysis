public class java_28143_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(String username, String password) {
        // Check password length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for number
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check for special character
        if (!password.matches(".*[!@#$%^&*()_+\\\\-=\\\\[\\]{};':\"\\\\|,.<>?].*")) {
            return false;
        }

        return true;
    }

    @Override
    public String getId() {
        return "Custom Validator";
    }
}