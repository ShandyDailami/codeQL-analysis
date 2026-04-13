import javax.security.auth.login.LoginException;

public class java_20842_CredentialValidator_A03 {

    private CredentialRepository credentialRepository;

    public java_20842_CredentialValidator_A03(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    public Credential authenticate(String username, String password) {
        try {
            Credential credential = credentialRepository.findByUsernameAndPassword(username, password);

            if (credential == null) {
                throw new LoginException("Invalid username or password");
            }

            return credential;
        } catch (Exception e) {
            throw new LoginException("Failed to authenticate user", e);
        }
    }
}