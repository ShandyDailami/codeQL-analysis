import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.LoginException;

public class java_29364_CredentialValidator_A01 {
    private Credential credential;

    public java_29364_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }

    public void changePassword(String newPassword) throws LoginException, PasswordChangeException {
        credential.setPassword(newPassword.toCharArray());
    }

    public void changeUsername(String newUsername) throws LoginException {
        credential.setUserName(newUsername);
    }

    public String getUsername() throws LoginException {
        return credential.getUserName();
    }

    public String getPassword() throws LoginException {
        return new String(credential.getPassword());
    }
}