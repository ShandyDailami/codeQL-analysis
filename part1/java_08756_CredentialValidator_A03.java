public class java_08756_CredentialValidator_A03 {

    // hard-coded username and password
    private static final String hardcodedUsername = "admin";
    private static final String hardcodedPassword = "password";

    // method to validate credentials
    public static boolean validateCredentials(String username, String password) {
        return hardcodedUsername.equals(username) && hardcodedPassword.equals(password);
    }

    public static void main(String[] args) {
        // test the credential validator
        if (validateCredentials("admin", "password")) {
            System.out.println("Credentials validated successfully!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}