public class java_00500_CredentialValidator_A08 implements CredentialValidator {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]+$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String username = credential.getIdentifier();
        String password = credential.getPasswordAsString();

        // Check if username matches pattern
        if (!username.matches(USERNAME_PATTERN)) {
            throw new CredentialException("Invalid username. It can only contain letters, numbers, and underscore.");
        }

        // Check if password matches pattern
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new CredentialException("Password must be at least 8 characters long and contain at least one number, one uppercase letter, one lowercase letter, and one special character.");
        }

        // If all checks pass, return true
        return true;
    }
}