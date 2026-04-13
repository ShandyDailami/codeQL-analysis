public class java_30493_CredentialValidator_A07 {

    // hardcoded password
    private static final String HARDCODED_PASSWORD = "password";

    public boolean validateCredentials(String enteredPassword) {
        // check if entered password is correct
        if (enteredPassword.equals(HARDCODED_PASSWORD)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Invalid password. Please try again.");
            return false;
        }
    }
}