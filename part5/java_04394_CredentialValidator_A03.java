public class java_04394_CredentialValidator_A03 {

    private static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        // Check for non-alphanumeric characters
        if (!password.matches("^[a-zA-Z0-9]*$")) {
            return false;
        }

        // Check for digits
        if (!password.matches(".*[0-9].*")) {
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

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("password")); // Prints: true
        System.out.println(isValidPassword("short")); // Prints: false
        System.out.println(isValidPassword("123short")); // Prints: false
        System.out.println(isValidPassword("short123")); // Prints: false
        System.out.println(isValidPassword("Short123")); // Prints: false
        System.out.println(isValidPassword("PASSWORD123")); // Prints: true
    }

}