public class java_21249_CredentialValidator_A03 {

    // Check if password length is at least 8
    public static boolean isValidPasswordLength(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    // Check if password contains at least one digit
    public static boolean isValidPasswordDigit(String password) {
        if (password.matches(".*[0-9].*")) {
            return true;
        } else {
            return false;
        }
    }

    // Check if password contains at least one uppercase letter
    public static boolean isValidPasswordUppercase(String password) {
        if (password.matches(".*[A-Z].*")) {
            return true;
        } else {
            return false;
        }
    }

    // Check if password contains at least one lowercase letter
    public static boolean isValidPasswordLowercase(String password) {
        if (password.matches(".*[a-z].*")) {
            return true;
        } else {
            return false;
        }
    }

    // Main function to validate the password
    public static boolean validatePassword(String password) {
        if (isValidPasswordLength(password) && isValidPasswordDigit(password) && isValidPasswordUppercase(password) && isValidPasswordLowercase(password)) {
            return true;
        } else {
            return false;
        }
    }
}