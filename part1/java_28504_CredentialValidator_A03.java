public class java_28504_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentity().toString();
        String password = credential.getCredentials().toString();

        if (username.length() < 6 || password.length() < 8) {
            return false;
        }

        if (!(username.matches(".*[A-Z].*") && username.matches(".*[a-z].*") && username.matches(".*[!@#$%^&*(),.?\":{}|<>].*"))) {
            return false;
        }

        return true;
    }
}