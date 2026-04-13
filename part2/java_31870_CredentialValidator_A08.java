public class java_31870_CredentialValidator_A08 {

    // Method to validate if password is strong
    public static boolean isPasswordStrong(String password) {
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

        if (!password.matches(".*[@#$%^&*()?/\\\\|{}<>].*")) {
            return false;
        }

        return true;
    }

    // Main method to test the password validation
    public static void main(String[] args) {
        String password = "StrongPassword@123";
        if (isPasswordStrong(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak.");
        }
    }
}