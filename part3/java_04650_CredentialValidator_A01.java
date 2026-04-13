public class java_04650_CredentialValidator_A01 {

    private String username;
    private String password;

    // Constructor
    public java_04650_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Static credentials for testing purposes
        String staticUsername = "admin";
        String staticPassword = "password";

        // Validate credentials
        return this.username.equals(staticUsername) && this.password.equals(staticPassword);
    }

    public static void main(String[] args) {
        // Create a CredentialValidator with a known username and password
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Validate the credentials
        boolean isValid = validator.validate();

        // Output the result
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}