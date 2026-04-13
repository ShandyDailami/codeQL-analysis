public class java_26209_CredentialValidator_A08 implements CredentialValidator {

    private String expectedUsername;
    private String expectedPassword;

    public java_26209_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws InvalidCredentialsException {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // This is a simple comparison. In a real-world application, you'd want to use a secure hash
        // function (like bcrypt) to compare the passwords. Also, you'd want to store the hashed
        // passwords in the database, not the plaintext passwords.
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            return true;
        } else {
            throw new InvalidCredentialsException("Invalid username or password");
        }
    }
}