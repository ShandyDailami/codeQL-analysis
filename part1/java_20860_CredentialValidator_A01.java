public class java_20860_CredentialValidator_A01 implements CredentialValidator {

    // The next CredentialValidator to use for subsequent calls to validateCredentials
    private CredentialValidator next;

    public java_20860_CredentialValidator_A01(CredentialValidator next) {
        this.next = next;
    }

    @Override
    public CredentialValidationResult validate(Credential c) throws GeneralSecurityException {
        // We'll assume the username and password here for simplicity
        String username = c.getIdentifier();
        String password = c.getCredential();

        // Here's a placeholder for checking against a database of known good usernames and passwords
        if (username.equals("admin") && password.equals("password")) {
            return new CredentialValidationResult(true, "User Authenticated Successfully");
        } else {
            return new CredentialValidationResult(false, "Invalid Credentials");
        }
    }

    @Override
    public Set<String> getUses() {
        return new HashSet<>(Arrays.asList("validate"));
    }

    @Override
    public Set<String> getCallsForUses() {
        return new HashSet<>(Arrays.asList("validate"));
    }
}