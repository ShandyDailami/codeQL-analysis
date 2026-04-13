public class java_10561_CredentialValidator_A08 {

    // Define a hardcoded password
    private static final String HARDCODED_PASSWORD = "password";

    // Define a method to check if a password is strong enough
    public static boolean isPasswordStrongEnough(String password) {
        // Check if password is null
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check if password is the hardcoded password
        if (password.equals(HARDCODED_PASSWORD)) {
            return false;
        }

        // Check if password is too short
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if password contains at least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // If all checks passed, password is strong enough
        return true;
    }

    public static void main(String[] args) {
        // Use the method in a main method
        String password = "thisIsATestPassword";
        if (isPasswordStrongEnough(password)) {
            System.out.println("Password is strong enough");
        } else {
            System.out.println("Password is not strong enough");
        }
    }
}