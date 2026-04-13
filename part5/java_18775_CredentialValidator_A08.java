public class java_18775_CredentialValidator_A08 {

    public static boolean validatePassword(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password is weak (less than 8 characters)
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains a digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if password contains a special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        // Check if password contains a lower case letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if password contains a upper case letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Testing
        System.out.println(validatePassword("Password@123")); // true
        System.out.println(validatePassword("password")); // false
        System.out.println(validatePassword("Password")); // false
        System.out.println(validatePassword("Password@")); // false
        System.out.println(validatePassword("Password@1")); // false
    }
}