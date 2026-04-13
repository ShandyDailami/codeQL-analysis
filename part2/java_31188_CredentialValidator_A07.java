public class java_31188_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        // For simplicity, we're just checking if the username is 'admin' and the password is 'admin'.
        // In a real-world application, you should use a more secure way of validating credentials.
        if ("admin".equals(credential.getIdentity().getPasswordAsString())) {
            return true;
        } else {
            throw new CredentialException("Invalid username or password");
        }
    }
}