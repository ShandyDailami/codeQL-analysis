public class java_36939_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "1234567890";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String username = credential.getIdentity().getName();
        char[] passwordChars = credential.getCredentials().clone();

        if (username == null || username.length() == 0) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        if (passwordChars == null || passwordChars.length == 0) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        // Check for length and special character requirement
        if (passwordChars.length < 8 || !containsSpecialCharacter(passwordChars) || !containsNumber(passwordChars)) {
            return false;
        }

        // Check for password complexity, here just a simple rule
        for (char c : passwordChars) {
            if (!Character.isAlphabetic(c) && !Character.isNumeric(c) && !SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                return false;
            }
        }

        return true;
    }

    private boolean containsSpecialCharacter(char[] passwordChars) {
        for (char c : passwordChars) {
            if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNumber(char[] passwordChars) {
        for (char c : passwordChars) {
            if (NUMBERS.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}