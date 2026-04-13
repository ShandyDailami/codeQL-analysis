public class java_41401_CredentialValidator_A03 implements CredentialValidator {
    private String validUserName;
    private String validPassword;

    public java_41401_CredentialValidator_A03(String validUserName, String validPassword) {
        this.validUserName = validUserName;
        this.validPassword = validPassword;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String userName = credential.getIdentity().getName();
        String password = new String(credential.getCredentials());

        if (userName.equals(validUserName) && password.equals(validPassword)) {
            return true;
        } else {
            return false;
        }
    }
}