import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

import sun.security.util.auth.PKCS11Utils;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class java_14661_CredentialValidator_A07 implements CredentialValidator {

    private PrivateKey privateKey;
    private X509Certificate certificate;

    public java_14661_CredentialValidator_A07(PrivateKey privateKey, X509Certificate certificate) {
        this.privateKey = privateKey;
        this.certificate = certificate;
    }

    @Override
    public Subject getSubject(CallbackHandler callbackHandler)
            throws AuthenticationException, UnsupportedCallbackException {

        Callback[] callbacks = new Callback[]{new PrivateKeyCallback(privateKey)};
        Subject subject = callbackHandler.handle(callbacks);
        return subject;
    }

    private static class PrivateKeyCallback implements Callback {

        private PrivateKey privateKey;

        public java_14661_CredentialValidator_A07(PrivateKey privateKey) {
            this.privateKey = privateKey;
        }

        @Override
        public void handle(Callback callback) throws AuthenticationException, UnsupportedCallbackException {
            PKCS11Utils.PrivateKeyCallbackHandler handler = new PKCS11Utils.PrivateKeyCallbackHandler(privateKey);
            handler.handle(callback);
        }
    }
}