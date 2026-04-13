import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_34471_CredentialValidator_A07 {

    private CredentialStore credentialStore;

    public java_34471_CredentialValidator_A07(CredentialStore credentialStore) {
        this.credentialStore = credentialStore;
    }

    public CredentialStatus validate(String username, String password) {
        try {
            credentialStore.login(username, password);
            return CredentialStatus.SUCCESS;
        } catch (CredentialNotFoundException e) {
            return CredentialStatus.USER_NOT_FOUND;
        } catch (LoginException e) {
            return CredentialStatus.INVALID_PASSWORD;
        } catch (Exception e) {
            return CredentialStatus.UNEXPECTED_ERROR;
        }
    }

    public enum CredentialStatus {
        SUCCESS, USER_NOT_FOUND, INVALID_PASSWORD, UNEXPECTED_ERROR
    }

    public interface CredentialStore {
        void login(String username, String password) throws LoginException, CredentialNotFoundException;
    }
}