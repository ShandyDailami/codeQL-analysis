public class java_13749_CredentialValidator_A01 {
    // This is a placeholder for actual authentication system
    private boolean authenticate(String username, String password) {
        // Placeholder for actual authentication logic
        // Return true if authenticated, false otherwise
        return username.equals("admin") && password.equals("password");
    }

    // CredentialValidator that validates username and password
    public class CredentialValidator implements java.security.AuthenticationValidator {
        private LegacyCredentialValidator legacyCredentialValidator;

        public java_13749_CredentialValidator_A01() {
            legacyCredentialValidator = new LegacyCredentialValidator();
        }

        @Override
        public String validate(AuthenticationToken arg0) throws java.lang.IllegalArgumentException {
            // Extract username and password from AuthenticationToken
            String username = arg0.getToken().toString();
            String password = arg0.getCredentials().toString();

            // Authenticate with legacy system
            boolean isAuthenticated = legacyCredentialValidator.authenticate(username, password);

            // Return an error message if not authenticated
            if (!isAuthenticated) {
                return "Invalid username or password";
            }

            // If authenticated, return null
            return null;
        }
    }
}