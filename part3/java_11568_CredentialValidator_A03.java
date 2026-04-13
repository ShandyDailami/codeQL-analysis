public class java_11568_CredentialValidator_A03 implements CredentialValidator {

    // A secret key that only the credential validator should know about
    private static final String SECRET_KEY = "secretKey";

    @Override
    public boolean validate(Credential credential) throws AuthenticationFailedException {
        // The credential contains a username and password
        String username = credential.getUsername();
        String password = credential.getPassword();

        // First, we check if the secret key matches the password.
        // This is a very simple way to demonstrate a credential validation attack.
        // In a real-world application, you should use a secure way to store and compare passwords.
        if (!SECRET_KEY.equals(password)) {
            throw new AuthenticationFailedException("Invalid password");
        }

        // Then, we check if the username and password match some known credentials.
        // In a real-world application, you should use a secure way to store and compare usernames and passwords.
        // In this example, we only check if it matches "admin/admin".
        if ("admin".equals(username) && "admin".equals(password)) {
            return true;
        }

        throw new AuthenticationFailedException("Invalid username or password");
    }
}