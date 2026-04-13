public class java_27580_CredentialValidator_A03 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String providedUsername = "admin";
        String providedPassword = "password";

        if (validateCredentials(providedUsername, providedPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    // Method to validate the credentials.
    public static boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match.
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}