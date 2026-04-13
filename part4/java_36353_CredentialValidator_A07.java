public class java_36353_CredentialValidator_A07 {

    // method for checking if a password is valid
    public static boolean isValidPassword(String password) {
        // If password is null or less than 8 characters, it is not valid
        if (password == null || password.length() < 8) {
            return false;
        }

        // If password contains any uppercase letters, it is valid
        if (password.matches(".*[A-Z].*")) {
            return true;
        }

        // If password contains any lowercase letters, it is valid
        if (password.matches(".*[a-z].*")) {
            return true;
        }

        // If password contains any digits, it is valid
        if (password.matches(".*\\d.*")) {
            return true;
        }

        // If password contains any special characters, it is valid
        if (password.matches(".*[^a-zA-Z0-9].*")) {
            return true;
        }

        // If password is secure, it is valid
        return true;
    }

    // method for checking if a username is valid
    public static boolean isValidUsername(String username) {
        // If username is null or less than 2 characters, it is not valid
        if (username == null || username.length() < 2) {
            return false;
        }

        // If username contains any uppercase letters, it is valid
        if (username.matches(".*[A-Z].*")) {
            return true;
        }

        // If username contains any lowercase letters, it is valid
        if (username.matches(".*[a-z].*")) {
            return true;
        }

        // If username is secure, it is valid
        return true;
    }

    // method for checking if a credential is valid
    public static boolean isValidCredential(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}