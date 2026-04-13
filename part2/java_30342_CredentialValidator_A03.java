public class java_30342_CredentialValidator_A03 {

    public static boolean validateCredentials(String username, String password) {
        // Check if password is valid
        if (!isValidPassword(password)) {
            return false;
        }

        // Check if username is valid
        if (!isValidUsername(username)) {
            return false;
        }

        // If both credentials are valid, return true
        return true;
    }

    // Method to check if password is valid
    private static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        return true;
    }

    // Method to check if username is valid
    private static boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }

        if (username.length() < 4) {
            return false;
        }

        if (!username.matches(".*[a-zA-Z].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("admin", "Password@123")); // True
        System.out.println(validateCredentials("admin", "admin")); // False
        System.out.println(validateCredentials("admin", null)); // False
        System.out.println(validateCredentials("admin", "password")); // False
        System.out.println(validateCredentials("admin", "12345678")); // False
    }
}