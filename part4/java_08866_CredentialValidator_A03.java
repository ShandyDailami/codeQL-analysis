public class java_08866_CredentialValidator_A03 implements CredentialValidator {

    private Set<String> validUsernames;

    public java_08866_CredentialValidator_A03(Set<String> validUsernames) {
        this.validUsernames = validUsernames;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String presentedPassword = credential.getCredentials().toString();
        return validUsernames.contains(credential.getIdentity().getName());
    }
}