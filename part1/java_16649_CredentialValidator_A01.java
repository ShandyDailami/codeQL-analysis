import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.UsernameNotFoundException;
import javax.security.auth.message.AuthException;

public class java_16649_CredentialValidator_A01 {

    // Assuming the CredentialStore is in memory
    private CredentialStore credentialStore;

    public java_16649_CredentialValidator_A01() {
        credentialStore = new CredentialStore();
    }

    public void validate(String username, String password) throws UsernameNotFoundException, AuthException {
        Credential credential = credentialStore.get(username);

        if (credential == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        if (!credential.getPassword().equals(password)) {
            throw new AuthException("Invalid password");
        }
    }

    public void changePassword(String username, String oldPassword, String newPassword) throws PasswordChangeException, AuthException {
        Credential credential = credentialStore.get(username);

        if (credential == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        if (!credential.getPassword().equals(oldPassword)) {
            throw new AuthException("Invalid password");
        }

        credential.setPassword(newPassword);
    }
}