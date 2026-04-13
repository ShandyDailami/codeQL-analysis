public class java_23243_CredentialValidator_A01 implements CredentialValidator {

    private static final String VALID_USERNAME = "test";
    private static final String VALID_PASSWORD = "test";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String presentedPassword = credential.getPasswordAsString();
        String presentedUsername = credential.getIdentifier();

        return validateCredentials(presentedUsername, presentedPassword);
    }

    private boolean validateCredentials(String presentedUsername, String presentedPassword) {
        return VALID_USERNAME.equals(presentedUsername)
                && VALID_PASSWORD.equals(presentedPassword);
    }
}