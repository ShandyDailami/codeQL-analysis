public class java_18028_CredentialValidator_A08 implements CredentialValidator {

    private static final String[] BLOCKED_PATTERNS = {"password", "password123", "123456", "abc123"};

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPasswordAsString();

        for (String blockedPattern : BLOCKED_PATTERNS) {
            if (password.matches(blockedPattern)) {
                System.out.println("Blocked password pattern found: " + blockedPattern);
                return false;
            }
        }

        return true;
    }

    @Override
    public void initialize(final String name, final Set<String> attributes) {
        // no-op
    }

    @Override
    public void reset() {
        // no-op
    }

    @Override
    public void close() {
        // no-op
    }
}