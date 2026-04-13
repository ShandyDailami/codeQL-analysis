public class java_33739_CredentialValidator_A01 {

    // Hard-coded credentials. For real use cases, this should be securely stored.
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // This is a simple example of a user's username and password.
    // In a real use case, these would come from a secure storage or a database.
    private String providedUsername;
    private String providedPassword;

    public java_33739_CredentialValidator_A01(String providedUsername, String providedPassword) {
        this.providedUsername = providedUsername;
        this.providedPassword = providedPassword;
    }

    public boolean validate() {
        // Check if provided username and password match hard-coded credentials.
        return providedUsername.equals(USERNAME) && providedPassword.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Create a validator with hard-coded credentials.
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Validate the validator.
        if (validator.validate()) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}