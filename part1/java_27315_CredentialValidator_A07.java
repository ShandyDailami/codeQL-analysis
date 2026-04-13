public class java_27315_CredentialValidator_A07 implements CredentialValidator {

    // A hardcoded password pattern for simplicity
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = new String(credential.getCredentials());

        // Password must match the hardcoded pattern
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new CredentialException("Password does not match the pattern.");
        }

        return true;
    }
}