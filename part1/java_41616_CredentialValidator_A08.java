public class java_41616_CredentialValidator_A08 {

    // Pre-defined password
    private static final String PREDEFINED_PASSWORD = "password";

    // Method to validate the password
    public static boolean validateCredentials(String password) {
        // Check if the password matches the predefined password
        if (password.equals(PREDEFINED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the program
        System.out.println("Is the password correct? " + validateCredentials("password"));
    }
}