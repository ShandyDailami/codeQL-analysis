import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_09695_SocketServer_A07 {

    private static final String KEYSTORE_FILE = "client.keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_FILE = "truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "client";

    public static void main(String[] args) throws CertificateException, IOException {
        SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory(KEYSTORE_FILE, KEYSTORE_PASSWORD, TRUSTSTORE_FILE, TRUSTSTORE_PASSWORD, KEY_ALIAS);
        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(4444);
        SSLServerSocket sslServer = (SSLServerSocket) serverSocket;
        sslServer.setNeedClientAuth(true);

        while (true) {
            Socket socket = sslServer.accept();
            SSLSocket sslSocket = (SSLSocket) socket;
            InetAddress ip = sslSocket.getInetAddress();
            System.out.println("Client IP: " + ip.getHostAddress());
            sslSocket.startHandshake();
            sslSocket.close();
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory(String keystoreFile, String keystorePassword, String truststoreFile, String truststorePassword, String keyAlias) throws CertificateException, IOException {
        char[] keystorePass = keystorePassword.toCharArray();
        char[] truststorePass = truststorePassword.toCharArray();

        KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keystoreFile, keystorePass);
        TrustManagerFactory trustManagerFactory = getTrustManagerFactory(truststoreFile, truststorePass);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        sslServerSocketFactory.setKeyManagers(keyManagerFactory.getKeyManagers());
        sslServerSocketFactory.setTrustManagers(trustManagerFactory.getTrustManagers());

        return sslServerSocketFactory;
    }

    private static KeyManagerFactory getKeyManagerFactory(String keystoreFile, char[] keystorePass) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream(keystoreFile), keystorePass);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, keystorePass);

        return keyManagerFactory;
    }

    private static TrustManagerFactory getTrustManagerFactory(String truststoreFile, char[] truststorePass) throws IOException, CertificateException {
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream(truststoreFile), truststorePass);

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        return trustManagerFactory;
    }
}