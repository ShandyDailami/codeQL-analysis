public class java_16394_CredentialValidator_A07 {
    // predefined username and password
    private String predefinedUsername = "admin";
    private String predefinedPassword = "password";

    // current username and password
    private String currentUsername;
    private String currentPassword;

    // constructor
    public java_16394_CredentialValidator_A07(String currentUsername, String currentPassword) {
        this.currentUsername = currentUsername;
        this.currentPassword = currentPassword;
    }

    // method to validate the username and password
    public boolean validateCredentials() {
        return this.currentUsername.equals(this.predefinedUsername) && 
               this.currentPassword.equals(this.predefinedPassword);
    }

    // main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.validateCredentials()); // prints: true
    }
}