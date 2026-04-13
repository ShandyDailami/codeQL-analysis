public class java_20960_CredentialValidator_A07 {

    private static final String SPECIAL_CHARACTERS = "!@#%^&*";

    public static void main(String[] args) {
        System.out.println(isValid("Password@123")); // Should print true
        System.out.println(isValid("password@123")); // Should print false
    }

    public static boolean isValid(String password) {
        // Check length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for lowercase
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for number
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check for special character
        if (!password.matches(".*[" + SPECIAL_CHARACTERS + "].*")) {
            return false;
        }

        return true;
    }
}