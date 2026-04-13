import java.security.Key;
import java.security.KeyStore;
import java.security.Principal;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class java_36205_CredentialValidator_A03 implements LoginModule {

    private String username = null;
    private String password = null;
    private boolean useDelegate = true;

    public java_36205_CredentialValidator_A03() {
    }

    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Properties properties) throws UnsupportedCallbackException {
        this.username = properties.getProperty("username");
        this.password = properties.getProperty("password");
        this.useDelegate = Boolean.parseBoolean(properties.getProperty("useDelegate"));
    }

    public boolean commit() {
        return true;
    }

    public boolean abort() {
        return false;
    }

    public Key getKey() {
        return null;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean supports(String authenticationType) {
        return authenticationType.equals("CHALLENGE");
    }

    public boolean supports(Class authenticationType) {
        return authenticationType.isAssignableFrom(Principal.class);
    }

    public boolean validate(Subject subject, Principal principal) {
        return principal != null;
    }

    public boolean validate(Subject subject, String username, String password) {
        return username != null && password != null;
    }

    public boolean validate(Subject subject, Principal principal, String password) {
        return principal != null && password != null;
    }

    public boolean validate(Subject subject, String username, String password, String callerQualifier) {
        return username != null && password != null;
    }

    public boolean validate(Subject subject, Principal principal, String password, String callerQualifier) {
        return principal != null && password != null;
    }

    public boolean validate(Subject subject, String username, String password, String callerQualifier, Key key) {
        return username != null && password != null;
    }

    public boolean validate(Subject subject, Principal principal, String password, String callerQualifier, Key key) {
        return principal != null && password != null;
    }

    public boolean validate(Subject subject, String username, String password, String callerQualifier, Key key, AuthenticationService authenticationService) {
        return username != null && password != null;
    }

    public boolean validate(Subject subject, Principal principal, String password, String callerQualifier, Key key, AuthenticationService authenticationService) {
        return principal != null && password != null;
    }
}