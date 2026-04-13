public class java_09259_CredentialValidator_A08 {
    // Simulate hardcoded credentials
    private static String hardcodedUsername = "admin";
    private static String hardcodedPassword = "password";

    // Credential object to store user credentials
    private Credential credential;

    public java_09259_CredentialValidator_A08(Credential credential) {
        this.credential = credential;
    }

    public boolean validate() {
        // Use equals method to compare the entered username and password
        // with the hardcoded ones
        if (credential.getUsername().equals(hardcodedUsername)
                && credential.getPassword().equals(hardcodedPassword)) {
            System.out.println("Validated successfully!");
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a Credential object and pass it to the CredentialValidator
        Credential credential = new Credential("admin", "password");
        CredentialValidator validator = new CredentialValidator(credential);

        // Use the validate method to check if the Credential is valid
        validator.validate();
    }
}

class Credential {
    private String username;
    private String password;

    public java_09259_CredentialValidator_A08(String username, String password) {
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