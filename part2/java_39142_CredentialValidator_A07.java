public class java_39142_CredentialValidator_A07 {
    // A method to check if the password meets the criteria
    public static boolean validate(String password) {
        // Check if the password is null
        if (password == null) {
            return false;
        }

        // Check if the password is long enough (minimum 8 characters)
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one uppercase letter
        if (!containsUppercase(password)) {
            return false;
        }

        // Check if the password contains at least one lowercase letter
        if (!containsLowercase(password)) {
            return false;
        }

        // Check if the password contains at least one number
        if (!containsNumber(password)) {
            return false;
        }

        // If all criteria are met, return true
        return true;
    }

    // A method to check if a string contains a specific character
    private static boolean containsChar(String str, char c) {
        return str.indexOf(c) != -1;
    }

    // A method to check if the password contains an uppercase letter
    private static boolean containsUppercase(String password) {
        return containsChar(password, Character.toUpperCase(password.charAt(0)));
    }

    // A method to check if the password contains a lowercase letter
    private static boolean containsLowercase(String password) {
        return containsChar(password, Character.toLowerCase(password.charAt(0)));
    }

    // A method to check if the password contains a number
    private static boolean containsNumber(String password) {
        return containsChar(password, Character.forDigit(0, 10));
    }
}