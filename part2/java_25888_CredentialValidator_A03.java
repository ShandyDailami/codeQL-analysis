public class java_25888_CredentialValidator_A03 {

    public static void main(String[] args) {
        String password = "yourStrongPassword";
        if (validatePassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }

    public static boolean validatePassword(String password) {
        // Check for minimum length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letter
        if (!containsUppercase(password)) {
            return false;
        }

        // Check for lowercase letter
        if (!containsLowercase(password)) {
            return false;
        }

        // Check for digit
        if (!containsDigit(password)) {
            return false;
        }

        // Check for special character
        if (!containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private static boolean containsUppercase(String password) {
        // Use regex to check for uppercase letter
        return password.matches(".*[A-Z].*");
    }

    private static boolean containsLowercase(String password) {
        // Use regex to check for lowercase letter
        return password.matches(".*[a-z].*");
    }

    private static boolean containsDigit(String password) {
        // Use regex to check for digit
        return password.matches(".*[0-9].*");
    }

    private static boolean containsSpecialCharacter(String password) {
        // Use regex to check for special character
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}