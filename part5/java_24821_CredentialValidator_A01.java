public class java_24821_CredentialValidator_A01 {
    public static boolean isValidPassword(String password) {
        // Check if the password is null or is less than 8 characters long
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check if the password contains only alphanumeric characters
        if (!password.matches(".*[a-zA-Z0-9].*")) {
            return false;
        }

        // Check if the password contains at least one upper-case letter, one lower-case letter, and one digit
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // If all checks pass, the password is valid
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Password@123")); // Should print true
        System.out.println(isValidPassword("password")); // Should print false
        System.out.println(isValidPassword("PASSWORD123")); // Should print false
        System.out.println(isValidPassword("Password@")); // Should print false
    }
}