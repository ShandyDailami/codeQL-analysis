public class java_39239_CredentialValidator_A01 implements CredentialValidator {

    private static final String[] PASSWORDS = {"password1", "password2", "password3", "password4"};

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String presentedPassword = credential.getPassword();
        for (String password : PASSWORDS) {
            if (password.equals(presentedPassword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean upgradeAuthStatus(UsernamePasswordCredential credential, AuthenticationStatus authStatus) {
        // No security-sensitive operations in this example, so we ignore the authStatus parameter
        return false;
    }
}