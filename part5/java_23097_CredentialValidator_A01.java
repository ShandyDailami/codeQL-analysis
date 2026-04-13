public class java_23097_CredentialValidator_A01 implements CredentialValidator {

    private static final List<String> VALID_NAMES = Arrays.asList("admin", "user1", "user2");

    @Override
    public boolean validate(Credential credential) {
        String userName = credential.getUsername();
        return VALID_NAMES.contains(userName);
    }

    @Override
    public boolean present(Credential credential) {
        return false;
    }

    @Override
    public boolean clear(Credential credential) {
        return false;
    }
}