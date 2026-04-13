import javax.security.auth.Subject;
import javax.security.auth.authentication.UsernamePasswordAuthenticationToken;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class java_15624_CredentialValidator_A07 implements AuthenticationService {

    @Override
    public Subject login() throws LoginException {
        return login("admin", "password");
    }

    @Override
    public Subject login(String username, String password) throws LoginException {
        if ("admin".equals(username) && "password".equals(password)) {
            return new Subject(new AuthenticatedPrincipal("admin"), new AuthenticatedGrantedAuthority("ROLE_ADMIN"));
        } else if ("user".equals(username) && "password".equals(password)) {
            return new Subject(new AuthenticatedPrincipal("user"), new AuthenticatedGrantedAuthority("ROLE_USER"));
        } else {
            return null;
        }
    }

    @Override
    public Subject logout(Subject subject) throws LoginException {
        // no-op
        return null;
    }

    @Override
    public boolean isCallerAnonymous() {
        // no-op
        return false;
    }

    @Override
    public boolean supportsStaticCallbackHandler() {
        // no-op
        return false;
    }

    @Override
    public LoginModule getLoginModule() {
        // no-op
        return null;
    }

    @Override
    public boolean validate(Subject subject, Credential credential) throws LoginException {
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) credential;
        if ("admin".equals(authToken.getPrincipal()) && "password".equals(authToken.getCredentials())) {
            return true;
        } else if ("user".equals(authToken.getPrincipal()) && "password".equals(authToken.getCredentials())) {
            return true;
        } else {
            return false;
        }
    }
}