import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import javax.security.auth.x500.X500Principal;
import java.util.Enumeration;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.KeyManagementException;

public class java_12314_CredentialValidator_A07 {
    private KeyStore keyStore;
    private SSLContext sslContext;

    public java_12314_CredentialValidator_A07(InputStream keyStoreInputStream, char[] keyStorePassword, InputStream trustStoreInputStream, char[] trustStorePassword) throws Exception {
        this.keyStore = KeyStore.getInstance("JKS");
        this.keyStore.load(keyStoreInputStream, keyStorePassword);

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(this.keyStore.getClass().getName());
        trustManagerFactory.init(this.keyStore);

        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

        this.sslContext = SSLContext.getInstance("TLS");
        this.sslContext.init(null, trustManagers, null);
    }

    public void validate(String target, CallbackHandler callbackHandler) {
        try {
            javax.security.auth.Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("", null);
                }
            };
            SSLConnectionSocketFactory connectionFactory = (SSLConnectionSocketFactory) sslContext.getSocketFactory();
            HttpsURLConnection connection = (HttpsURLConnection) SSLConnectionSocketFactoryTester.getConnection("https://" + target, connectionFactory, auth, callbackHandler);
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Connection successful, request: " + connection.getRequestMethod() + " " + connection.getRequestURL());
            } else {
                System.out.println("Connection failed, response code: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        InputStream keyStoreInputStream = CredentialValidator.class.getResourceAsStream("/client-keystore.jks");
        char[] keyStorePassword = "password".toCharArray();
        InputStream trustStoreInputStream = CredentialValidator.class.getResourceAsStream("/truststore.jks");
        char[] trustStorePassword = "password".toCharArray();
        CredentialValidator validator = new CredentialValidator(keyStoreInputStream, keyStorePassword, trustStoreInputStream, trustStorePassword);
        validator.validate("example.com", null);
    }
}