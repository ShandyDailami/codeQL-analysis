public class java_13238_CredentialValidator_A07 {
    // Start of CredentialValidator interface
    public interface CredentialValidator {
        boolean validate(String username, String password);
    }
    // End of CredentialValidator interface

    // Start of LegacyCredentialValidator class
    public class LegacyCredentialValidatorImpl implements CredentialValidator {
        private String expectedUsername = "admin";
        private String expectedPassword = "password";

        @Override
        public boolean validate(String username, String password) {
            // Simulate a fail in authentication by comparing the entered username and password with expected values
            if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
                System.out.println("Authentication failed");
                return false;
            } else {
                System.out.println("Authentication successful");
                return true;
            }
        }
    }
    // End of LegacyCredentialValidator class
}