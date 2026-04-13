public class java_38548_CredentialValidator_A03 {

    // Hard-coded username and password. In a real-world scenario, these would
    // likely be retrieved from a database or some other persistent storage.
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public static void main(String[] args) {
        String enteredUsername = "admin"; // The user entered username
        String enteredPassword = "password"; // The user entered password

        if (validateCredentials(enteredUsername, enteredPassword)) {
            System.out.println("Credentials valid.");
        } else {
            System.out.println("Credentials invalid.");
        }
    }

    private static boolean validateCredentials(String username, String password) {
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}