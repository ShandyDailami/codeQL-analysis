import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

import sun.security.x509.X509CertImpl;

public class java_02821_CredentialValidator_A08 implements javax.security.auth.credential.CredentialValidator {

    private CallbackHandler callbackHandler;

    @Override
    public void initialize(CallbackHandler callbackHandler, Map<String, ?> options)
            throws UnsupportedCallbackException, LoginException {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public X509Certificate[] getValidationResult(Callback[] callbacks)
            throws LoginException, CertificateException, UnsupportedCallbackException {

        // Simulate successful callback.
        Callback callback = callbacks[0];
        callback.setCallbackType("X509Certificate");
        callback.setStringParameter(new String[] { "X509Certificate" });

        // Parse and return the X509Certificate.
        String x509CertificateString = callback.getParameter("X509Certificate");
        return new X509Certificate[] { new X509CertImpl(x509CertificateString) };
    }

    @Override
    public boolean validate(Callback[] callbacks) throws LoginException, CertificateException, UnsupportedCallbackException {
        // Validate the result of the callback.
        X509Certificate[] certificates = getValidationResult(callbacks);
        return (certificates.length == 1);
    }
}