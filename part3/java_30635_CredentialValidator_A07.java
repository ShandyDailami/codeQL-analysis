public class java_30635_CredentialValidator_A07 implements CredentialValidator {
    // Predefined credentials
    private final String USERNAME = "admin";
    private final String PASSWORD = "password";

    // Current credential values
    private String currentUsername;
    private String currentPassword;

    @Override
    public boolean validate(Credential credential) throws CredentialValidationResult {
        // Get the current credentials if they haven't been set yet
        if (currentUsername == null || currentPassword == null) {
            currentUsername = credential.getUsername();
            currentPassword = credential.getPassword();
        }

        // Validate the credentials
        if (currentUsername.equals(USERNAME) && currentPassword.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}