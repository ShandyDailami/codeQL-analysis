import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;

public class java_30461_SocketServer_A08 {
    private static final String KEY_STORE = "path_to_your_keystore";
    private static final String KEY_STORE_PASSWORD = "your_keystore_password";
    private static final String TRUST_STORE = "path_to_your_truststore";
    private static final String TRUST_STORE_PASSWORD = "your_truststore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) throws IOException, CertificateException {
        SSLContext sslContext = getSSLContext(KEY_STORE, KEY_STORE_PASSWORD,
                TRUST_STORE, TRUST_STORE_PASSWORD, KEY_ALIAS);
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(8080);
        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();
            OutputStream out = clientSocket.getOutputStream();
            out.write("Hello, Client!".getBytes());
            out.flush();
            clientSocket.close();
        }
    }

    private static SSLContext getSSLContext(String keyStorePath, String keyStorePassword,
                                            String trustStorePath, String trustStorePassword,
                                            String keyAlias) throws IOException, CertificateException {
        KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keyStorePath, keyStorePassword);
        TrustManagerFactory trustManagerFactory = getTrustManagerFactory(trustStorePath, trustStorePassword);
        KeyStore clientKeystore = keyManagerFactory.getKeyStore();
        String clientKeyAlias = keyAlias;
        KeyStore trustStore = trustManagerFactory.getTrustStore();
        String trustAllCertsAlias = "trustAllCerts";

        clientKeystore.load(null, clientKeyAlias.toCharArray());
        trustStore.load(null, trustAllCertsAlias.toCharArray());

        return SSLContext.getInstance("SSL");
    }

    private static KeyManagerFactory getKeyManagerFactory(String keyStorePath, String keyStorePassword) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(keyStorePath), keyStorePassword.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyStore.getDefaultType());
        keyManagerFactory.init(keyStore, keyStorePassword.toCharArray());
        return keyManagerFactory;
    }

    private static TrustManagerFactory getTrustManagerFactory(String trustStorePath, String trustStorePassword) throws IOException, CertificateException {
        TrustStore trustStore = TrustStore.getInstance("JKS");
        trustStore.load(new FileInputStream(trustStorePath), trustStorePassword.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustStore.getDefaultType());
        trustManagerFactory.init(trustStore);
        return trustManagerFactory;
    }
}