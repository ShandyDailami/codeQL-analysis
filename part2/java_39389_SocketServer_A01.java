import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_39389_SocketServer_A01 {
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";
    private static final String ALIAS = "your_alias";

    public static void main(String[] args) throws IOException, CertificateException {
        KeyStore keystore = loadKeyStore(KEYSTORE_LOCATION, KEYSTORE_PASSWORD.toCharArray());
        KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keystore, KEY_PASSWORD.toCharArray());
        SSLContext sslContext = getSslContext(keyManagerFactory);

        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(new InetSocketAddress(8443));

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            new Handler(clientSocket).start();
        }
    }

    private static KeyStore loadKeyStore(String keyStoreLocation, char[] keyStorePassword) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new java.io.FileInputStream(keyStoreLocation), keyStorePassword);
        return keyStore;
    }

    private static KeyManagerFactory getKeyManagerFactory(KeyStore keyStore, char[] keyPassword) throws IOException, CertificateException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, keyPassword);
        return keyManagerFactory;
    }

    private static SSLContext getSslContext(KeyManagerFactory keyManagerFactory) throws SSLException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, null, null);
        return sslContext;
    }

    private static class Handler extends Thread {
        private SSLSocket socket;

        Handler(SSLSocket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle client connection
        }
    }
}