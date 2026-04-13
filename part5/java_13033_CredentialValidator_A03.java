public class java_13033_CredentialValidator_A03 {

    public static void main(String[] args) {
        String password = "password123"; // This is a password entered by the user.

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }

    public static boolean isValidPassword(String password) {
        // Check if the password is null or empty.
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password contains any common patterns.
        if (password.matches(".*[0-9].*") || password.matches(".*[a-zA-Z].*") || password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        // Check if the password is long enough.
        if (password.length() < 8) {
            return false;
        }

        // If all checks passed, the password is valid.
        return true;
    }
}