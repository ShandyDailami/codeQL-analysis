import java.security.InvalidParameterException;

public class java_14551_CredentialValidator_A07 {

    private CredentialRepository repository;

    public java_14551_CredentialValidator_A07(CredentialRepository repository) {
        this.repository = repository;
    }

    public void authenticate(String username, String password) throws InvalidParameterException {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }

        Credential credential = repository.findByUsername(username);

        if (credential == null) {
            throw new InvalidParameterException("Invalid username.");
        }

        if (!credential.isPasswordValid(password)) {
            throw new InvalidParameterException("Invalid password.");
        }

        // If everything is fine, update the user's last login time.
        credential.setLastLoginTime(System.currentTimeMillis());
        repository.save(credential);
    }
}