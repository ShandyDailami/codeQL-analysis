public class java_06495_CredentialValidator_A03 implements CredentialValidator {

    private String specificSequence;

    public java_06495_CredentialValidator_A03(String specificSequence) {
        this.specificSequence = specificSequence;
    }

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        String username = credentials.getUsername();
        if (username.contains(specificSequence)) {
            throw new AuthenticationFailedException("Username contains the sequence: " + specificSequence);
        }
        return true;
    }

}