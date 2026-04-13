public class java_06570_CredentialValidator_A03 {

    // Assume these are known valid usernames and passwords
    private static final String KNOWN_USERNAME = "admin";
    private static final String KNOWN_PASSWORD = "password";

    // CredentialValidator interface methods
    public boolean isValid(String username, String password) {
        return KNOWN_USERNAME.equals(username) && KNOWN_PASSWORD.equals(password);
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate credentials
        boolean isValid = validator.isValid("admin", "password");

        if(isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}