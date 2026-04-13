public class java_32004_CredentialValidator_A08 {
    // Username and password for successful validation
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Credentials to validate
    private String providedUsername;
    private String providedPassword;

    public java_32004_CredentialValidator_A08(String providedUsername, String providedPassword) {
        this.providedUsername = providedUsername;
        this.providedPassword = providedPassword;
    }

    public boolean isValid() {
        // Verify the credentials
        return this.providedUsername.equals(USERNAME) && this.providedPassword.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isValid()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}