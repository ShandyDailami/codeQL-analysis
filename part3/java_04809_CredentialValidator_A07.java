public class java_04809_CredentialValidator_A07 implements javax.security.auth.CredentialValidator<UsernamePasswordCredential> {

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) {
        String username = credential.getIdentifier();
        String password = credential.getPasswordAsString();

        // Static hardcoded username and password.
        if ("user".equals(username) && "password".equals(password)) {
            return null; // No error.
        } else {
            throw new javax.security.auth.login.FailedLoginException("Authentication failed.");
        }
    }
}