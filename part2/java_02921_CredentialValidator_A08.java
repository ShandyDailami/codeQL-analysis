public class java_02921_CredentialValidator_A08 {
    // In a real-world scenario, this would be an instance of a security service that validates credentials
    private SecurityService securityService;

    public java_02921_CredentialValidator_A08(SecurityService securityService) {
        this.securityService = securityService;
    }

    public Boolean validate(Credentials credentials) {
        // Assuming we are using a hardcoded username and password
        String username = "test";
        String password = "test";

        // Use the security service to check the provided credentials against the hardcoded values
        return securityService.validateCredentials(username, password, credentials.getUsername(), credentials.getPassword());
    }

    // Define the Credentials class
    public class Credentials {
        private String username;
        private String password;

        // Constructor, getters and setters
    }
}