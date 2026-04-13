public class java_34315_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String username = credential.getUsername();
        String password = credential.getPassword();

        // Simulate a password check with a simple string comparison
        if (password.equals("password")) {
            return CredentialValidationResult.failure(username);
        }

        return CredentialValidationResult.success();
    }

    @Override
    public void initialize(String name, Map<String, String> config) {
        // No setup required
    }

    @Override
    public void destroy(String name, Map<String, String> config) {
        // No cleanup required
    }
}