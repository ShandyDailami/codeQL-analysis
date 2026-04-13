public class java_04448_CredentialValidator_A07 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPassword();

        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password is long enough
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one digit
        if (!hasDigit(password)) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check if password contains at least one special character
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private boolean hasDigit(String s) {
        return s.matches(".*[0-9].*");
    }

    private boolean hasUpperCase(String s) {
        return s.matches(".*[A-Z].*");
    }

    private boolean hasSpecialCharacter(String s) {
        for (char c : s.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}