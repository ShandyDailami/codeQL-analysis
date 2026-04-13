import java.security.cert.X509Certificate;
import javax.net.ssl.SSLPeerEntity;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.Principal;
import java.security.cert.CertificateException;

public class java_15209_CredentialValidator_A08 implements javax.security.auth.credential.CredentialValidator {

    // The CredentialValidator will be called whenever an SSLSession is established,
    // allowing us to verify the server's identity.
    public void validate(SSLSocket socket) throws CertificateException, java.security.InvalidKeyException {
        SSLSession sslSession = socket.getSession();
        X509Certificate[] chain = sslSession.getPeerCertificateChain();

        // This is a very basic example, you may want to use a more complex certificate chain check
        if (chain.length == 0) {
            throw new CertificateException("No certificate chain in the SSLSession");
        }

        X509Certificate cert = chain[0];

        // Check if the certificate is expired
        if (cert.getNotAfter().before(new java.util.Date())) {
            throw new CertificateException("Certificate has expired");
        }
    }

    // The CredentialValidator will be called when a new Callback is required
    public void getRequestedCredentials(SSLSocket socket, String target, String authType, CallbackHandler callbackHandler, Principal[] authzIds) throws CertificateException, UnsupportedCallbackException {
        // We don't actually need to do anything in this method, so it doesn't actually do anything.
    }
}