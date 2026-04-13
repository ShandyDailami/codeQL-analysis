import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

import javax.security.auth.Subject;
import javax.security.auth.x500.X500Principal;

import javax.security.auth.login.LoginModule;

public class java_35554_CredentialValidator_A03 implements LoginModule {
    private String username;

    public java_35554_CredentialValidator_A03(String username) {
        this.username = username;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
        // no-op
    }

    @Override
    public boolean commit() throws LoginException, UnsupportedCallbackException {
        return true;
    }

    @Override
    public String getPassword(String s) throws LoginException, UnsupportedCallbackException {
        return "password";
    }

    @Override
    public String getUsername() throws LoginException, UnsupportedCallbackException {
        return this.username;
    }

    @Override
    public X500Principal getX500Principal() throws LoginException, UnsupportedCallbackException {
        return new X500Principal("CN=" + this.username + ", OU=Example, O=Example, C=US");
    }
}

public class CredentialValidator {
    private LoginModule[] modules;

    public java_35554_CredentialValidator_A03() {
        this.modules = new LoginModule[] { new CustomLoginModule("user") };
    }

    public boolean validate(X509Certificate cert, String authType) throws CertificateException {
        // no-op
        return true;
    }
}