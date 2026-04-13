public class java_11055_CredentialValidator_A07 {
    // This is a very simple validation method
    public boolean validateCredentials(String username, String password) {
        // This is a very basic validation. In a real-world application, you would
        // likely want to connect to a database or authentication service to check
        // the username and password against a set of expected values.
        return "admin".equals(username) && "password".equals(password);
    }

    public static void main(String[] args) {
        // Create a new instance of the legacy validator
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Try to validate the credentials
        if (validator.validateCredentials("admin", "password")) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}