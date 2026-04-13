public class java_11606_CredentialValidator_A07 {

    // Hardcoded username and password.
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // No-argument constructor for the sake of encapsulation.
    public java_11606_CredentialValidator_A07() { }

    // Method to validate user credentials.
    public boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}

// Usage
public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validateCredentials("admin", "password");
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}