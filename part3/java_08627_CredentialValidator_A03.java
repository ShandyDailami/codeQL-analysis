public class java_08627_CredentialValidator_A03 {
    private String username;
    private String password;

    // Constructor
    public java_08627_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Hardcoded set of credentials
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        // Check if the credentials match
        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}

// Testing the CredentialValidator
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        boolean isValid = validator.validate();
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}