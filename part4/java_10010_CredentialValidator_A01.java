public class java_10010_CredentialValidator_A01 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentity();
        String password = credential.getCredentials();

        // Check if password meets requirements
        if (password.length() < 8 || !hasUpperCase(password) || !hasLowerCase(password)
                || !hasDigit(password) || !hasSpecialCharacter(password)) {
            throw new GeneralSecurityException("Password does not meet requirements");
        }

        // Continue with authentication using the username and password
        return true;
    }

    private boolean hasUpperCase(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDigit(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialCharacter(String input) {
        for (char c : input.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}