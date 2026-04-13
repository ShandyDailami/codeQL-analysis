public class java_23573_CredentialValidator_A08 {

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        // Check for length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letters
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for lowercase letters
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for numbers
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check for special characters
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        // If all the checks are passed
        return true;
    }

    public static void main(String[] args) {
        String password = "Password@123";
        if (isPasswordStrong(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }
    }
}