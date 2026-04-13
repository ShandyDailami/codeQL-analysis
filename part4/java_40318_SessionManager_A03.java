import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class java_40318_SessionManager_A03 {

    private SSLContext sslContext;

    public java_40318_SessionManager_A03() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public javax.security.auth.login.LoginException validate(java.security.cert.Certificate[] cert, String authType) throws CertificateException {
                return null;
            }

            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        } };

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(null);

        sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
    }

    public SSLContext getSslContext() {
        return sslContext;
    }
}