public class java_34882_CredentialValidator_A01 {
    // Credential object to store the user's credentials
    private Credential credential;

    // Constructor
    public java_34882_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }

    // Method to validate the credential
    public boolean validate() {
        // Check if the username and password match a predefined list
        if (credential.getUsername().equals("admin") && credential.getPassword().equals("password")) {
            // If they match, return true
            return true;
        } else {
            // If they don't match, return false
            return false;
        }
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        // Create a CredentialValidator for the user "admin" with password "password"
        CredentialValidator validator = new CredentialValidator(new Credential("admin", "password"));

        // Test the validate method
        if (validator.validate()) {
            System.out.println("Credential is valid.");
        } else {
            System.out.println("Credential is invalid.");
        }
    }
}

class Credential {
    private String username;
    private String password;

    public java_34882_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}