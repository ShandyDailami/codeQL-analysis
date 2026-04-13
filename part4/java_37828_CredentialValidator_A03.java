public class java_37828_CredentialValidator_A03 {

    public boolean isPasswordValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check if the password is long enough
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains any uppercase letter
        if (!containsUpperCase(password)) {
            return false;
        }

        // Check if the password contains any special character
        if (!containsSpecialCharacter(password)) {
            return false;
        }

        // If all checks are passed, the password is valid
        return true;
    }

    private boolean containsUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        // Here we assume a special character is any character that is not alphanumeric
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}