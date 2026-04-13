public class java_24655_CredentialValidator_A07 {
    private String correctUsername;
    private String correctPassword;

    public java_24655_CredentialValidator_A07() {
        // Assuming these are our hard-coded credentials
        this.correctUsername = "user";
        this.correctPassword = "password";
    }

    public boolean validateCredentials(String username, String password) {
        if (username.equals(this.correctUsername) && password.equals(this.correctPassword)) {
            System.out.println("Validated successfully!");
            return true;
        } else {
            System.out.println("Invalid credentials. Please try again.");
            return false;
        }
    }
}