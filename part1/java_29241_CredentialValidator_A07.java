public class java_29241_CredentialValidator_A07 implements CredentialValidator {

    private List<String> acceptedDomains;
    private List<String> acceptedUsernames;

    public java_29241_CredentialValidator_A07(List<String> acceptedDomains, List<String> acceptedUsernames) {
        this.acceptedDomains = acceptedDomains;
        this.acceptedUsernames = acceptedUsernames;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String username = credential.getIdentifier();
        String domain = credential.getCaller();

        // Check if username and domain are in the accepted lists
        if (!acceptedUsernames.contains(username) || !acceptedDomains.contains(domain)) {
            throw new AuthenticationFailedException("Authentication failed: Invalid username or domain");
        }

        return true;
    }
}