public class java_16810_CredentialValidator_A07 implements CredentialValidator {

    private String correctUsername;
    private String correctPassword;

    public java_16810_CredentialValidator_A07(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String user = credential.getIdentity();
        String password = credential.getCredentials();

        if (user.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}