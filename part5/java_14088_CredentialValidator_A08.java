public class java_14088_CredentialValidator_A08 {

    // Constant expected password
    private static final String EXPECTED_PASSWORD = "password";

    // Method to validate the user's password
    public static boolean validatePassword(String enteredPassword) {
        // If the entered password matches the expected password
        if (enteredPassword.equals(EXPECTED_PASSWORD)) {
            System.out.println("Successful login!");
            return true;
        } else {
            System.out.println("Failed login. Please try again.");
            return false;
        }
    }
}