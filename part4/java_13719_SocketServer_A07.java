import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_13719_SocketServer_A07 {

    private static final String KEYSTORE = "path/to/your.keystore";
    private static final char[] KEYSTORE_PASSWORD = 'your_password'.toCharArray();
    private static final String TRUSTSTORE = "path/to/your_truststore";
    private static final char[] TRUSTSTORE_PASSWORD = 'your_truststore_password'.toCharArray();
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();
        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);
        SSLServerSocket sslServer = (SSLServerSocket) serverSocket;
        sslServer.setNeedClientAuth(true);

        // load keystore and truststore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(KEYSTORE), KEYSTORE_PASSWORD);

        // load trusted certificates
        KeyManagerFactory kmf = getKeyManagerFactory(keyStore, KEYSTORE_PASSWORD);
        KeyManagerFactory tmf = getTrustManagerFactory(TRUSTSTORE, TRUSTSTORE_PASSWORD);

        sslServer.setKeyManagers(kmf.getKeyManagers());
        sslServer.setTrustManagers(tmf.getTrustManagers());

        while (true) {
            Socket socket = sslServer.accept();
            SSLSocket sslSocket = (SSLSocket) socket;
            InetAddress remoteAddress = sslSocket.getRemoteSocketAddress();
            System.out.println("Accepted connection from " + remoteAddress);
            // handle socket here
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() throws Exception {
        KeyManagerFactory kmf = getKeyManagerFactory(null, null);
        TrustManagerFactory tmf = getTrustManagerFactory(null, null);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslServer.getSocketFactory();
        sslServerSocketFactory.setKeyManager(kmf.getKeyManagers());
        sslServerSocketFactory.setTrustManager(tmf.getTrustManagers());

        return sslServerSocketFactory;
    }

    private static KeyManagerFactory getKeyManagerFactory(KeyStore keyStore, char[] keyStorePassword) throws Exception {
        return KeyManagerFactory.getInstance("SunKSAPI");
    }

    private static TrustManagerFactory getTrustManagerFactory(String truststore, char[] truststorePassword) throws Exception {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(new KeyStoreStreamSource(truststore, truststorePassword));

        return trustManagerFactory;
    }
}