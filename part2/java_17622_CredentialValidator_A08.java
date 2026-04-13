public class java_17622_CredentialValidator_A08 {

    public static boolean isValidPassword(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password length is less than 8
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, one digit and one special character
        if (!(password.matches(".*[A-Z].*")) || !(password.matches(".*[a-z].*")) || !(password.matches(".*\\d.*")) || !(password.matches(".*[!@#$%^&*(),.?\":{}|\\\\]*"))) {
            return false;
        }

        // If all checks pass, password is valid
        return true;
    }

    public static void main(String[] args) {
        // Test passwords
        System.out.println(isValidPassword("AwesomePassword123!")); // true
        System.out.println(isValidPassword("Awesome123!")); // false, password is too short
        System.out.println(isValidPassword("AwesomePassword123")); // false, password does not contain at least one special character
        System.out.println(isValidPassword("Awesome")); // false, password is too short
    }
}