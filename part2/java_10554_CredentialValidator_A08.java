public class java_10554_CredentialValidator_A08 {

    public static boolean validate(String password) {
        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains a lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if password contains an uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if password contains a number
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check if password contains a special character
        if (!password.matches(".*[~`^$~!@#$%^&*()_+=-].*")) {
            return false;
        }

        // If all checks passed, return true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password@123")); // Should print true
        System.out.println(validate("password")); // Should print false
    }
}