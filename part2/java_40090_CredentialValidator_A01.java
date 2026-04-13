public class java_40090_CredentialValidator_A01 {
    // Fields
    private String username;
    private String password;

    // Constructor
    public java_40090_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to check if the credentials are valid
    public boolean isValid() {
        // Simulate the authentication process
        if (this.username != null && this.username.equals("admin") && this.password != null && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test with valid credentials
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isValid()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }

        // Test with invalid credentials
        CredentialValidator invalidValidator = new CredentialValidator("invalid", "invalid");
        if (invalidValidator.isValid()) {
            System.out.println("Invalid credentials are valid.");
        } else {
            System.out.println("Invalid credentials are not valid.");
        }
    }
}