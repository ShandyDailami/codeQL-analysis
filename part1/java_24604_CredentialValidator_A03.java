import java.security.cert.X509Certificate;
import java.util.Optional;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.security.auth.x500.X500Principal;

public class java_24604_CredentialValidator_A03 {

    private static final String KEYSTORE_TYPE = "PKCS12";
    private static final String KEYSTORE_PATH = "/path/to/your.keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";

    public static void main(String[] args) {
        Optional<X509Certificate> certificate = validateCertificate();

        if (certificate.isPresent()) {
            System.out.println("Certificate validated successfully!");
        } else {
            System.out.println("Certificate validation failed!");
        }
    }

    private static Optional<X509Certificate> validateCertificate() {
        try {
            SSLContext sslContext = createSSLContext();
            SSLEngine sslEngine = sslContext.createSSLEngine("https://your.site.com");
            sslEngine.setRequestor(null);
            sslEngine.getSession().setWantServerCertificateCheck(true);
            sslEngine.setNeedClientAuth(true);
            sslEngine.startHandshake();
            X509Certificate[] certificates = sslEngine.getSession().getPeerCertificates();
            if (certificates.length == 0) {
                throw new RuntimeException("No certificates received from server");
            }
            return Optional.of(certificates[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static SSLContext createSSLContext() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagers, null);
        return sslContext;
    }
}