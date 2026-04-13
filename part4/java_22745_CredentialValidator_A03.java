public class java_22745_CredentialValidator_A03 implements CredentialValidator {

    private static final String VALID_PREFIX = "A";

    @Override
    public boolean validate(Credential credential) {
        if (credential == null || credential.getUsername() == null) {
            throw new IllegalArgumentException("Credential or username is null");
        }
        return credential.getUsername().startsWith(VALID_PREFIX);
    }

    @Override
    public List<String> getInvalidCredentials() {
        return Collections.emptyList();
    }

    @Override
    public String getName() {
        return "Username Validator";
    }
}