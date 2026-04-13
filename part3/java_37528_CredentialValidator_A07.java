import java.util.Base64;
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.Subject;
import javax.security.auth.authenticator.Authenticator;
import javax.security.auth.authenticator.AuthenticatorCallback;
import javax.security.auth.authenticator.AuthenticatorException;

public class java_37528_CredentialValidator_A07 implements Authenticator {
    private String userName;
    private String password;

    public java_37528_CredentialValidator_A07(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Subject authenticate(Subject subject, Credential credential) throws AuthenticatorException {
        String username = credential.getIdentifier();
        PasswordAuthentication passwordAuth = (PasswordAuthentication) credential;
        String password = new String(Base64.getDecoder().decode(passwordAuth.getCredential().getPassword()));

        if (this.userName.equals(username) && this.password.equals(password)) {
            return subject;
        } else {
            throw new AuthenticatorException("Authentication failed");
        }
    }
}

public class CredentialValidator {
    private Authenticator authenticator;

    public java_37528_CredentialValidator_A07(String userName, String password) {
        this.authenticator = new Authenticator() {
            @Override
            public Subject authenticate(Subject subject, Credential credential) throws AuthenticatorException {
                return new CustomAuthenticator(userName, password).authenticate(subject, credential);
            }
        };
    }

    public void validate() {
        try {
            authenticator.authenticate(Subject.currentSubject(), new UsernamePasswordCredential("", ""));
        } catch (LoginException e) {
            System.out.println("Authentication failed");
        } catch (AuthenticatorException e) {
            System.out.println("Authentication failed");
        }
    }
}