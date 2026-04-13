public class java_25193_CredentialValidator_A08 {
    // A simple method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Replace this with a more secure method to compare passwords
        // For simplicity, we'll use a hard-coded value
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validateCredentials("admin", "password");

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}