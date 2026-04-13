import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControlException;
import java.security.auth.Authenticator;
import java.security.auth.login.PasswordAuthenticationToken;
import java.security.auth.Credential;

public class java_33923_CredentialValidator_A07 implements LoginModule {
    private String username;
    private String password;

    public java_33923_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Subject login() throws LoginException {
        Authenticator authenticator = new Authenticator() {
            @Override
            public PasswordAuthenticationToken authenticate(Credential credential) throws AccessControlException {
                String providedUsername = credential.getIdentifier();
                if (username.equals(providedUsername) && password.equals(providedUsername)) {
                    return new PasswordAuthenticationToken(username, password, null);
                } else {
                    throw new AccessDeniedException("Authentication failed");
                }
            }
        };

        return authenticator.authenticate(new PasswordAuthenticationToken(username, password));
    }
}