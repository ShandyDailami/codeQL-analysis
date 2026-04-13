public class java_33048_CredentialValidator_A08 implements CredentialValidator {

    // Stored hashes for demonstration purposes
    private static final String PASSWORD = "$2a$10$e.JQVzNQbv4EfNzR9FU.i2r5W9W.JQVzNQbv4EfNzR9FU.i2r5W9W";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String presentedPassword = credential.getPasswordAsString();

        // Compare the hashed password to the presented password
        if (PASSWORD.equals(presentedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}