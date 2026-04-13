import java.security.cert.CertificateException;
import java.security.cert.Certificate;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_14677_CredentialValidator_A07 implements LoginModule {

    private String username = null;
    private char[] password = null;

    public String getPassword() {
        return new String(this.password);
    }

    public String getLoginModule() {
        return this.getClass().getName();
    }

    public void initialize(String newPassword, javax.security.auth.Subject subject) throws CredentialNotFoundException, LoginException {
        this.username = subject.getPrincipal().toString();
        this.password = newPassword.toCharArray();
    }

    public boolean commit() throws CredentialNotFoundException, LoginException {
        // if we get here, credentials are correct
        return true;
    }

    public void cleanup() {
        // empty method required by spec
    }
}