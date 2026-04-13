public class java_26131_CredentialValidator_A01 implements CredentialValidator {

    private String username;
    private String password;

    public java_26131_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        if (credential.getUsername() != null && credential.getUsername().equals(username) &&
            credential.getPassword() != null && credential.getPassword().equals(password)) {
            return true;
        }
        throw new InvalidCredentialException("Invalid username or password");
    }
}