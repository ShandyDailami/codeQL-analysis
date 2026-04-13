public class java_24510_CredentialValidator_A08 {

    public boolean validate(String password) {
        // Avoid using external frameworks.
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password should not be null or empty");
        }

        // Minimum 8 characters, at least one uppercase letter, one lowercase letter, one digit, one special character.
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password length should be at least 8 characters");
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(c) == -1) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

}