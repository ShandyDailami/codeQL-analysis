public class java_15090_CredentialValidator_A01 {

    // Private class to store credential details
    private final String username;
    private final String password;

    // Constructor to create a new validator
    public java_15090_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the credential
    public boolean validate() {
        // Here we're assuming that all users with a username of 'admin' and password of 'password' have admin rights.
        // In reality, the actual implementation should securely store user credentials and compare them to the entered credentials.
        return username.equals("admin") && password.equals("password");
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        boolean isValid = validator.validate();
        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}