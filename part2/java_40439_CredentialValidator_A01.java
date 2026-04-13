public class java_40439_CredentialValidator_A01 {

    // Assume these are hard-coded rules.
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public static boolean validateCredentials(String username, String password) {
        // Check if the username is valid.
        if (!username.equals(VALID_USERNAME)) {
            System.out.println("Invalid username. Credentials are not allowed.");
            return false;
        }

        // Check if the password is valid.
        if (!password.equals(VALID_PASSWORD)) {
            System.out.println("Invalid password. Credentials are not allowed.");
            return false;
        }

        // If all credentials are valid, return true.
        System.out.println("Access granted!");
        return true;
    }

    public static void main(String[] args) {
        validateCredentials("admin", "password");
    }
}