public class java_11992_CredentialValidator_A07 {
    // Minimum required password length
    private static final int PASSWORD_LENGTH = 10;

    // Check if a password meets the minimum length requirement
    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        return password.length() >= PASSWORD_LENGTH;
    }

    // Check if a password meets the requirement for containing at least one uppercase letter
    public static boolean isStrongPassword(String password) {
        if (!isValidPassword(password)) {
            return false;
        }

        boolean upperCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                upperCase = true;
                break;
            }
        }
        return upperCase;
    }

    // Check if a password meets the requirement for containing at least one lowercase letter
    public static boolean isWeakPassword(String password) {
        if (!isValidPassword(password)) {
            return false;
        }

        boolean lowerCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                lowerCase = true;
                break;
            }
        }
        return lowerCase;
    }

    // Check if a password meets the requirement for containing at least one digit
    public static boolean isMediumPassword(String password) {
        if (!isValidPassword(password)) {
            return false;
        }

        boolean digit = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digit = true;
                break;
            }
        }
        return digit;
    }

    // Check if a password meets the requirement for not being too common
    public static boolean isSecurePassword(String password) {
        if (!isValidPassword(password)) {
            return false;
        }

        String commonPasswords = "password, admin, qwerty, 123456"; // List of common passwords
        return !commonPasswords.contains(password);
    }
}