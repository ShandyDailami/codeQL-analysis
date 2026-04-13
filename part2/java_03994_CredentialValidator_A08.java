public class java_03994_CredentialValidator_A08 {

    // Array of hard-coded credentials
    private static String[][] hardCodedCredentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        // Add more hard-coded credentials here
    };

    // Method to validate a username and password
    public static boolean validateCredentials(String enteredUsername, String enteredPassword) {
        for (String[] credential : hardCodedCredentials) {
            if (credential[0].equals(enteredUsername) && credential[1].equals(enteredPassword)) {
                return true; // Credentials match, return true
            }
        }
        return false; // Credentials do not match, return false
    }

    public static void main(String[] args) {
        // Example of using the validateCredentials method
        boolean isValid = validateCredentials("user1", "password1");
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}