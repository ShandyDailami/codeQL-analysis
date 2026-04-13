public class java_30769_CredentialValidator_A03 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=-[]{};:',.<>?/`~";

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check for at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase and lowercase letters
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for a special character
        if (!password.contains(String.valueOf(SPECIAL_CHARACTERS.charAt(0)))) {
            return false;
        }

        // Check for a digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        return true;
    }

}