import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

public class java_15177_CredentialValidator_A07 implements CallbackHandler {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public String getCallerPrincipal() {
        return USERNAME;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public void initialize(Subject subject, Callback[] callbacks) throws AuthenticationException {
        // No need for initialization in this case
    }

    @Override
    public boolean unsupportedCallback(String callback) throws UnsupportedCallbackException {
        return false;
    }

}

public class CustomSubject extends Subject {

    private String principal;
    private String callingPrincipal;
    private String callingAuthzID;

    public java_15177_CredentialValidator_A07(String principal) {
        this.principal = principal;
    }

    @Override
    public String getPrincipal() {
        return principal;
    }

    @Override
    public String getCallingPrincipal() {
        return callingPrincipal;
    }

    @Override
    public String getCallingAuthzID() {
        return callingAuthzID;
    }

    @Override
    public boolean hasRole(String role) {
        // In this case, we only check if the principal is the same as the hard-coded username
        return principal.equals(role);
    }

}

public class CustomAuthenticator implements Authenticator {

    private String username;
    private String password;

    public java_15177_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Subject authenticate(Subject subject) throws AuthenticationException {
        // In this case, we only authenticate if the username and password match
        if (username.equals(subject.getPrincipal()) && password.equals(subject.getPassword())) {
            return new CustomSubject(username);
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }

    @Override
    public boolean supports(String authMethod) {
        return authMethod.equals("CUSTOM");
    }

}

public class CustomAuthProvider implements AuthenticationProvider {

    @Override
    public Authenticator getAuthenticator() {
        return new CustomAuthenticator(null, null);
    }

    @Override
    public boolean supports(String authenticationMethod) {
        return authenticationMethod.equals("CUSTOM");
    }

}