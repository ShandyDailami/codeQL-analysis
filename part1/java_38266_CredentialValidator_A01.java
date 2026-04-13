public class java_38266_CredentialValidator_A01 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()";

    @Override
    public boolean validate(String username, String password) {
        // Check if password contains at least one uppercase letter, one lowercase letter, one number, and one special character
        if (!(password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*") && password.matches(".*[" + SPECIAL_CHARACTERS + "].*"))) {
            return false;
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        return true;
    }
}