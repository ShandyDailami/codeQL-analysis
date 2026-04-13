public class java_32238_CredentialValidator_A01 {
    private String correctUsername = "admin";
    private String correctPassword = "password";

    // Simple method to check if the provided credentials match our predefined ones.
    public boolean isValid(String username, String password) {
        return username.equals(correctUsername) && password.equals(correctPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Attempt to log in with correct credentials.
        if (validator.isValid("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}