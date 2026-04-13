import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLPeerEntity;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import java.security.cert.X509Certificate;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.io.IOException;
import java.security.cert.X509Certificate;

public class java_26395_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(InputStream credential, String challenge)
            throws CredentialException, IOException, CredentialSpec {
        // Get the challenge response
        byte[] response = challenge.getBytes();
        // Check the response
        for (int i = 0; i < response.length; i++) {
            if (credential.read() != response[i]) {
                throw new CredentialException("Invalid response at index " + i);
            }
        }
        // If all tests passed, the credential is valid
        return true;
    }

    @Override
    public boolean getSupported(String authenticationSpec) {
        // The authentication spec we are interested in is "SSL"
        return authenticationSpec.equals("SSL");
    }

    @Override
    public String getInstanceSpecification() {
        // The instance specification is "TLS"
        return "TLS";
    }
}