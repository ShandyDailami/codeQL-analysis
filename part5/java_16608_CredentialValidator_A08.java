public class java_16608_CredentialValidator_A08 {

    // Predefined username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Verify credential method
    public static boolean verifyCredential(String username, String password) {
        return (USERNAME.equals(username) && PASSWORD.equals(password));
    }

    public static void main(String[] args) {
        // Testing the CredentialValidator
        boolean isVerified = CredentialValidator.verifyCredential("admin", "password");
        if (isVerified) {
            System.out.println("Credentials verified!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}