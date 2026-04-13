public class java_27278_CredentialValidator_A07 implements CredentialValidator {
    private String username;
    private String password;

    public java_27278_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(Credential credential) throws BadCredentialsException {
        // Replace this with a method that actually authenticates against a database
        // For example, this could be a method that takes the username and password
        // and compares them to those stored in a database.
        if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
            return true;
        } else {
            throw new BadCredentialsException("Incorrect username or password");
        }
    }
}