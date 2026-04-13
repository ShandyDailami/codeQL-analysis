public class java_10279_CredentialValidator_A01 {
    // Define a known username and password.
    private static final String KNOWN_USERNAME = "test";
    private static final String KNOWN_PASSWORD = "test";

    // Define a method to validate the given credentials.
    public static boolean validate(String username, String password) {
        if (username.equals(KNOWN_USERNAME) && password.equals(KNOWN_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    // Define a main method to test the validator.
    public static void main(String[] args) {
        // Define some test cases.
        String testUsername = "test";
        String testPassword = "test";
        String wrongUsername = "wrong";
        String wrongPassword = "wrong";

        // Test the validator with some test cases.
        System.out.println("Is test user valid? " + validate(testUsername, testPassword));
        System.out.println("Is wrong user valid? " + validate(wrongUsername, wrongPassword));
    }
}