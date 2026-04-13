public class java_40952_CredentialValidator_A03 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+={}[]|\\:<>,.?/;'";

    public boolean validatePassword(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

        // Check for length
        if (password.length() < 8) {
            return false;
        }

        // Check for presence of special characters
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // Check for uppercase letters
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check for lowercase letters
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check for numbers
        if (!hasNumber(password)) {
            return false;
        }

        return true;
    }

    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasNumber(String password) {
        for (char c : password.toCharArray()) {
            if (Character.getNumericValue(c) >= 0 && Character.getNumericValue(c) <= 9) {
                return true;
            }
        }
        return false;
    }
}