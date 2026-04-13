public class java_22532_CredentialValidator_A01 implements CredentialValidator {

    // Implementation of CredentialValidator interface
    @Override
    public boolean validate(Credential c) {
        // Check if username is not null and has at least 3 characters
        if (c.getUsername() != null && c.getUsername().length() >= 3) {
            // Check if password is not null and has at least 6 characters
            if (c.getPassword() != null && c.getPassword().length() >= 6) {
                return true;
            }
        }
        return false;
    }
}