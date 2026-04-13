public class java_36606_CredentialValidator_A08 {

    public boolean isValidPassword(String password) {
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        // Assuming password has at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Assuming password has at least one uppercase letter, one lowercase letter and one digit
        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasUpperCase && hasLowerCase && hasDigit) {
                return true;
            }
        }
        return false;
    }
}