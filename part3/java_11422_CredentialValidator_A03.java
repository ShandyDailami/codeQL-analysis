import java.security.cert.X509Certificate;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.PrincipalNotFoundException;

import javax.security.auth.login.CredentialException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialCollection;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.LoginModule;

public class java_11422_CredentialValidator_A03 implements LoginModule {

    private Credential currentCredential;

    @Override
    public boolean validate(final CallbackHandler callbackHandler) throws CredentialException, UnsupportedCallbackException {
        Callback callback = callbackHandler.getCallback();

        try {
            if (callback != null) {
                PasswordCredential passwordCredential = new UsernamePasswordCredential(callback.getUsernameToTest(), callback.getPasswordCallback().getPassword());
                setCredential(passwordCredential);
            }
            return true;
        } finally {
            if (callback != null) {
                callback.handled(true);
            }
        }
    }

    @Override
    public boolean commit() throws CredentialException {
        return true;
    }

    @Override
    public void initialize(final CallbackHandler callbackHandler) throws CredentialException, UnsupportedCallbackException {
        validate(callbackHandler);
    }

    private void setCredential(final Credential credential) {
        this.currentCredential = credential;
    }

    public CredentialCollection getCredentialCollection() {
        return new CredentialCollection() {

            @Override
            public boolean validate(final CallbackHandler callbackHandler) throws CredentialException, UnsupportedCallbackException {
                LegacyCredentialValidator.this.validate(callbackHandler);
                return true;
            }

            @Override
            public boolean commit() throws CredentialException {
                LegacyCredentialValidator.this.commit();
                return true;
            }

            @Override
            public void initialize(final CallbackHandler callbackHandler) throws CredentialException, UnsupportedCallbackException {
                LegacyCredentialValidator.this.initialize(callbackHandler);
            }

            @Override
            public X509Certificate getX509Certificate() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public Principal getPrincipal() {
                return new Principal() {

                    @Override
                    public String getName() {
                        return LegacyCredentialValidator.this.currentCredential.getCaller();
                    }

                    @Override
                    public String getIssuer() {
                        return LegacyCredentialValidator.this.currentCredential.getCaller();
                    }
                };
            }

            @Override
            public boolean equals(final Object obj) {
                if (obj == null || !(obj instanceof Credential)) {
                    return false;
                }
                Credential credential = (Credential) obj;
                return credential.getCaller().equals(LegacyCredentialValidator.this.currentCredential.getCaller()) && credential.getPassword().equals(LegacyCredentialValidator.this.currentCredential.getPassword());
            }

            @Override
            public int hashCode() {
                return getCaller().hashCode() ^ getPassword().hashCode();
            }

            @Override
            public void eraseCredentials() {
                // do nothing
            }
        };
    }
}