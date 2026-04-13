import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_38275_SocketServer_A08 {

    private static final String KEYSTORE = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) throws Exception {

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(new java.security.KeyStoreReader(TRUSTSTORE, TRUSTSTORE_PASSWORD));

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(new java.security.KeyStoreReader(KEYSTORE, KEYSTORE_PASSWORD), KEYSTORE_PASSWORD);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.create(new ServerSocket(8080));
        sslServerSocketFactory.setKeyManagers(keyManagerFactory.getKeyManagers());
        sslServerSocketFactory.setTrustManagers(trustManagerFactory.getTrustManagers());

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket();
        sslServerSocket.setReuseAddress(true);

        while (true) {
            Socket socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(socket, true);
            sslSocket.setNeedClientAuthentication(true);
            X509Certificate[] chain = sslSocket.getEnabledCipherSuites();
            // Here, you can put your security-sensitive operations related to A08_IntegrityFailure
        }
    }
}