public class java_21335_CredentialValidator_A03 {
    public boolean validateCredential(String username, String password) {
        // Simulate a database lookup for the username
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Credentials validated successfully.");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredential("admin", "password");
    }
}