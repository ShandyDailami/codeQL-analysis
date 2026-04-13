import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_33392_CredentialValidator_A08 {

    private static final String KEYSTORE_TYPE = "JKS";
    private static final String KEYSTORE_PATH = "/path/to/keystore";
    private static final String KEYSTORE_PASSWORD = "keystorepassword";
    private static final String TRUSTSTORE_TYPE = "JKS";
    private static final String TRUSTSTORE_PATH = "/path/to/truststore";
    private static final String TRUSTSTORE_PASSWORD = "truststorepassword";

    private SSLContext sslContext;

    public void init() throws Exception {
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        keyStore.load(getClass().getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());
        kmf.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyStore trustStore = KeyStore.getInstance(TRUSTSTORE_TYPE);
        trustStore.load(getClass().getResourceAsStream(TRUSTSTORE_PATH), TRUSTSTORE_PASSWORD.toCharArray());
        tmf.init(trustStore);

        KeyManager[] keyManagers = kmf.getKeyManagers();
        TrustManager[] trustManagers = tmf.getTrustManagers();

        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, trustManagers, null);
    }

    public SSLEngine getSSLEngine(String serverHost) throws Exception {
        KeyManager[] km = sslContext.getKeyManagers();
        assert km != null;
        Certificate[] certs = km[0].getCertificateChain();
        assert certs != null;

        SSLEngine sslEngine = sslContext.createSSLEngine(serverHost);
        sslEngine.setUseClientMode(true);
        sslEngine.setNeedClientAuth(true);

        String encodedCert = Base64.getEncoder().encodeToString(certs[0].getEncoded());
        sslEngine.setCertificateRequest(new CertificateRequest(null, new String[]{encodedCert}, null, null, null, null));

        return sslEngine;
    }
}