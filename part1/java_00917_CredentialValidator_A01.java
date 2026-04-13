public class java_00917_CredentialValidator_A01 implements CredentialValidator {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String password = credential.getPasswordAsString();

        if (!password.matches(PASSWORD_PATTERN)) {
            throw new CredentialException("Password does not match the required pattern");
        }

        // Continue with the authentication process
        return true;
    }
}