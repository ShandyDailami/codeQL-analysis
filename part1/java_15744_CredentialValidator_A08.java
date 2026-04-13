public class java_15744_CredentialValidator_A08 {

    // The minimum password length is 8
    private static final int MIN_PASSWORD_LENGTH = 8;

    public boolean isPasswordStrong(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }
}