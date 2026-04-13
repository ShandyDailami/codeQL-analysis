public class java_22676_CredentialValidator_A08 implements CredentialValidator {

    // This is a hard-coded password. It's not secure to store in plain text.
    private final String hardCodedPassword = "mySecurePassword";

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        String presentedPassword = credential.getPassword();
        
        // If the presented password is null, it means the user didn't provide a password.
        // In a real-world application, you should handle this case differently.
        if (presentedPassword == null) {
            throw new InvalidCredentialException("Missing password", "MissingCredential");
        }

        // Check if the presented password matches the hard-coded password.
        if (presentedPassword.equals(hardCodedPassword)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid password", "InvalidCredential");
        }
    }
}