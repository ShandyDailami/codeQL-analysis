import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.Validator;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509Credential;
import java.security.Permission;
import java.security.Provider;
import java.security.cert.X509Certificate;

public class java_06278_CredentialValidator_A08 implements Validator, CallbackHandler {
    private Subject subject;
    private boolean enabled;

    public java_06278_CredentialValidator_A08() {
        this.enabled = false;
    }

    @Override
    public boolean validate(Subject subject, X509Certificate certificate) {
        return enabled && certificate != null;
    }

    @Override
    public boolean validate(Subject subject, X500Principal domain) {
        return enabled && domain != null;
    }

    @Override
    public boolean validate(Subject subject, Permission permission) {
        return enabled && permission != null;
    }

    @Override
    public boolean validate(Subject subject, String objectClassHint) {
        return enabled;
    }

    @Override
    public boolean validate(Subject subject, Object object) {
        return enabled && object != null;
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler, Object object) {
        return enabled;
    }

    @Override
    public Subject validate(CallbackHandler callbackHandler, Object object, Permission permission, X509Credential credential) {
        return enabled ? subject : null;
    }

    @Override
    public Subject validate(CallbackHandler callbackHandler, Object object, Permission permission, X509Credential credential, X500Principal domain) {
        return enabled ? subject : null;
    }

    @Override
    public Subject validate(CallbackHandler callbackHandler, Object object, Permission permission, String objectClass) {
        return enabled ? subject : null;
    }

    @Override
    public void init(CallbackHandler callbackHandler, Object object, Provider provider, X509Credential credential, X509Certificate certificate) throws LoginException {
        enabled = true;
        this.subject = subject;
    }

    @Override
    public void finalize(CallbackHandler callbackHandler, Object object, Provider provider, X509Credential credential, X509Certificate certificate, Subject subject) throws LoginException {
        enabled = false;
        this.subject = subject;
    }
}