public class java_35729_CredentialValidator_A03 implements CredentialValidator {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String presentedUsername = credential.getIdentifier();
        String presentedPassword = credential.getPasswordAsString();

        return VALID_USERNAME.equals(presentedUsername) && VALID_PASSWORD.equals(presentedPassword);
    }
}