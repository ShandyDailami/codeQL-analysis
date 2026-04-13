public class java_10509_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_10509_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Hard-coded data
        // Normally, these would come from a secure source (e.g. database)
        String hardCodedUsername = "admin";
        String hardCodedPassword = "password";

        if (this.username.equals(hardCodedUsername) && this.password.equals(hardCodedPassword)) {
            System.out.println("Validated successfully!");
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the CredentialValidator with some hard-coded data
        CredentialValidator validator = new CredentialValidator("admin", "password");
        validator.validate();
    }
}