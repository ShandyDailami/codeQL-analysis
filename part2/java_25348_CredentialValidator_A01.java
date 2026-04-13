public class java_25348_CredentialValidator_A01 implements CredentialValidator {

    // Hardcoded rules
    private static final String ALLOWED_PASSWORD = "password";

    @Override
    public boolean validate(CredentialContext context) throws CredentialValidationException {
        // Get the plain text password
        String password = context.getPasswordAsString();

        // Compare the password with the hardcoded rule
        if (password.equals(ALLOWED_PASSWORD)) {
            return true;
        } else {
            throw new CredentialValidationException("Invalid password");
        }
    }
}