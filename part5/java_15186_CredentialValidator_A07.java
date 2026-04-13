public class java_15186_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String username = credential.getIdentifier();
        char[] password = credential.getPassword();

        // Check if username starts with 'A' and password length is more than 5
        if (username.charAt(0) == 'A' && password.length > 5) {
            return true;
        } else {
            throw new AuthenticationFailedException("AuthFailure");
        }
    }
}