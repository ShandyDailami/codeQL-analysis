public class java_16633_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]}|;:',.<>?/";

    public static boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (!hasUpperCase(password)) {
            return false;
        }

        if (!hasLowerCase(password)) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        if (isInUse(password)) {
            return false;
        }

        return true;
    }

    private static boolean hasUpperCase(String password) {
        // Checks if password contains at least one upper case letter
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasLowerCase(String password) {
        // Checks if password contains at least one lower case letter
        return password.matches(".*[a-z].*");
    }

    private static boolean hasDigit(String password) {
        // Checks if password contains at least one digit
        return password.matches(".*\\d.*");
    }

    private static boolean hasSpecialCharacter(String password) {
        // Checks if password contains at least one of the specified special characters
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }

    private static boolean isInUse(String password) {
        // Here, we're just checking if the password is already in use.
        // In a real-world application, you would probably use a database or another form of persistent storage to check if a password is already in use.
        // For simplicity, we're assuming that we're only checking if the password is already in use.
        return true;
    }
}