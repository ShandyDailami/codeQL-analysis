public class java_15431_CredentialValidator_A08 {
    public static boolean isPasswordStrongEnough(String password) {
        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password has at least one uppercase letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check if password has at least one lowercase letter
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check if password has at least one special character
        if (!hasSpecialChar(password)) {
            return false;
        }

        // If all checks pass, password is strong enough
        return true;
    }

    private static boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecialChar(String password) {
        String specialChars = "!@#$%^&*()";
        for (char c : password.toCharArray()) {
            if (specialChars.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}