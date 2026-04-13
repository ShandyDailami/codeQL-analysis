public class java_30471_CredentialValidator_A01 {
    // Hardcoded credentials
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";

    // Inject the actual username and password for testing
    private String username;
    private String password;

    public java_30471_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // If both the username and password match the hardcoded values, return true
        return this.username.equals(CORRECT_USERNAME) && this.password.equals(CORRECT_PASSWORD);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a validator with the hardcoded credentials
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Validate the validator
        boolean isValid = validator.validate();

        // Output the result
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}