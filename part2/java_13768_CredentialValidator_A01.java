public class java_13768_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        // Length check
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check if password contains at least one lowercase letter
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check if password contains at least one digit
        if (!hasDigit(password)) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }

    private static boolean hasUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.getNumericValue(password.charAt(i)) >= 0 && Character.getNumericValue(password.charAt(i)) <= 9) {
                return true;
            }
        }
        return false;
    }
}